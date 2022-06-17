//package com.demo.mybatisx.poi;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.deepoove.poi.XWPFTemplate;
//import com.deepoove.poi.config.Configure;
//import com.deepoove.poi.config.ConfigureBuilder;
//import com.deepoove.poi.data.PictureRenderData;
//import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
//import com.deepoove.poi.util.BytePictureUtils;
//import com.phms.base.dao.*;
//import com.phms.base.enums.Gender;
//import com.phms.base.exception.LogicException;
//import com.phms.base.model.do_.*;
//import com.phms.base.model.do_.conclusion.HealthResultDO;
//import com.phms.base.model.do_.conclusion.HealthformResponseDTO;
//import com.phms.base.model.do_.dto.*;
//import com.phms.base.model.do_.lis.LisDetectDO;
//import com.phms.base.response.RestResponse;
//import com.phms.base.util.*;
//import com.phms.zl.config.PhmsGlobalConfig;
//import com.phms.zl.service.HealthformService;
//import com.phms.zl.service.PersonService;
//import com.phms.zl.service.ReportService;
//import com.phms.zl.util.Word2PdfUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//import javax.annotation.PostConstruct;
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//
///**
// * @author ：eason
// * @description：一键打印
// * @date： 2022/2/28 14:41
// */
//@Service
//public class ReportServiceImpl implements ReportService {
//    @Autowired
//    private PersonDao personDao;
//    @Autowired
//    private HealthformDao healthformDao;
//    @Autowired
//    private TcmDao tcmDao;
//    @Autowired
//    private UltrasoundDao ultrasoundDao;
//    @Autowired
//    private LisDao lisDao;
//    @Autowired
//    private QuickMeasureDao quickMeasureDao;
//    @Autowired
//    private PhmsGlobalConfig config;
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private HealthformService healthformService;
//    @Autowired
//    private HealthEducationDao healthEducationDao;
//    @Autowired
//    private PersonService personService;
//
//    @Autowired
//    private TemplateDao templateDao;
//    // 模板渲染 配置
//    private Configure renderConfigure;
//    private static final String ACUPOINT_MAP_PATH = "/home/tty/file/tcm/acupointMap/";
//
//    private static final String EXCEPTION = "异常结果";
//
//    private static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
//
//
//    @PostConstruct
//    public void initRenderConfigure() {
//        // 初始化模板渲染配置
//        ConfigureBuilder builder = Configure.newBuilder();
//        builder.buildGramer("${", "}");
//        HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();
//        builder.bind("healthResult", policy);
//        renderConfigure = builder.build();
//    }
//
//
//    @Override
//    public ReportListDO getReportList(String personId, String startDate, String endDate) {
//        DoctorDTO doctorDTO = RequestAttributes.getDoctor();
//        String region = doctorDTO.getRegion4Partion();
//        PersonDO personDO = personDao.selectById(personId, region);
//        if (null == personDO) {
//            throw new LogicException("未找到居民信息");
//        }
//        String cardId = personDO.getCardId();
//        ReportListDO reportListDO = new ReportListDO();
//        //设置居民档案
//        List<ReportDO> archives = new ArrayList<>();
//        archives.add(new ReportDO(personDO.getBuildDate(), personDO.getId()));
//        reportListDO.setArchives(archives);
//        //设置体检列表和体检告知单
//        List<ReportDO> healthForm = healthformDao.selectHealthFormListByPersonId(personId, startDate, endDate);
//        reportListDO.setHealthForm(healthForm);
//        reportListDO.setHealthFormLite(healthForm);
//        //设置老年人健康评估
//        List<ReportDO> healthFormOld = healthformDao.findOldListByPersonId(personId, startDate, endDate);
//        reportListDO.setHealthFormOld(healthFormOld);
//        //设置中医体质辨识
//        List<ReportDO> tcm = tcmDao.findTcmListByPersonId(personId, startDate, endDate);
//        reportListDO.setTcm(tcm);
//        //B超报告
//        List<ReportDO> bul = ultrasoundDao.getUltrasoundFileListByPersonId(startDate, endDate, personId);
//        if (CollectionUtils.isEmpty(bul)) {
//            bul = ultrasoundDao.getUltrasoundFileListByCardId(startDate, endDate, cardId);
//        }
//        reportListDO.setB_ultrasound(bul);
//        //lis
////        List<ReportDO> lis = lisDao.findLisFromHealthForm(cardId, startDate, endDate);
////        reportListDO.setBiochemical(lis);
//        //心电
//        List<ReportDO> ecg = quickMeasureDao.findEcgByPersonId(personId, startDate, endDate);
//        reportListDO.setEcg(ecg);
//        return reportListDO;
//    }
//
//
//    /**
//     * 生成一键打印报告
//     *
//     * @param personId
//     * @param startDate
//     * @param endDate
//     * @return
//     */
//    public RestResponse getReport(String personId, String startDate, String endDate) {
//        RestResponse restResponse = new RestResponse();
//        DoctorDTO doctorDTO = RequestAttributes.getDoctor();
//        String region = doctorDTO.getRegion4Partion();
//        Map<String, Object> map = new HashMap<>();
//        List<String> wordPath = new ArrayList<>();
//        PersonDO personDO = personDao.selectById(personId, region);
//        if (null == personDO) {
//            logger.error("综合报告生成未找到居民信息{},{}", personId, region);
//            restResponse.setError(-1, "未找到居民信息");
//            return restResponse;
//        }
//        String cardId = personDO.getCardId();
//        String indexPath = buildPersonData(personDO, doctorDTO, map);
//        if (StringUtil.isNotEmpty(indexPath)) {
//            wordPath.add(indexPath);
//        }
//        Healthform healthform = healthformDao.selectLastHealthFormByCardIdAndTime(cardId, region, startDate, endDate);
//        if (null != healthform) {
//            HealthformWrapperDTO wrapperDTO = null;
//            String mtId = healthform.getMtId();
//            if (StringUtil.isNotEmpty(mtId)) {
//                RestResponse response = personService.getService("201608141448077152", mtId);
//                if (response.isSuccess()) {
//                    wrapperDTO = (HealthformWrapperDTO) response.getData();
//                    healthform = wrapperDTO.getData();
//                }
//            } else {
//                wrapperDTO = healthformService.getHealthformDetail(healthform.getId(), region);
//            }
//            HealthformConclusionDTO conclusion = wrapperDTO.convertConclusion("1");
//            conclusion.setAge(DateUtils.computAgeInt(null, cardId, personDO.getBirthday()));
//            conclusion.setName(personDO.getName());
//            String gender = personDO.getGenderCode();
//            conclusion.setGender(gender);
//            String result = null;
//            try {
//                logger.info("调用软服接口参数：：" + JSON.toJSONString(conclusion));
//                result = restTemplate.postForObject(config.getAnalysisUrl(), conclusion, String.class);
//                logger.info("软服返回数据：" + JSON.toJSONString(result));
//            } catch (Exception e) {
//                logger.error("调用软服接口失败:", e);
//            }
//            map.put("examDate", healthform.getExamDate());
//            String healthResultPath = buildHealthResultData(result, map);
//            if (StringUtil.isNotEmpty(healthResultPath)) {
//                wordPath.add(healthResultPath);
//            }
////            String healthCommonPath = buildHealthCommonData(healthform, map);
////            if (StringUtil.isNotEmpty(healthCommonPath)) {
////                wordPath.add(healthCommonPath);
////            }
//        }
//        //Lis数据+体检基本信息
//        buildHealthCommonData2(healthform, map);
//        List<LisDetectDO> detectDOS = lisDao.selecLisByCardIdV2(cardId, region);
//        String checkPath = buildLisData(detectDOS, map, healthform);
//        if (StringUtil.isNotEmpty(checkPath)) {
//            wordPath.add(checkPath);
//        }
////        logger.info("一键打印lis数据：" + JSON.toJSONString(detectDOS));
////        String xcgPath = buildLisData(detectDOS, "1", map, healthform);
////        if (StringUtil.isNotEmpty(xcgPath)) {
////            wordPath.add(xcgPath);
////        }
////        String shPath = buildLisData(detectDOS, "3", map, healthform);
////        if (StringUtil.isNotEmpty(shPath)) {
////            wordPath.add(shPath);
////        }
////        String ncgPath = buildLisData(detectDOS, "2", map, healthform);
////        if (StringUtil.isNotEmpty(ncgPath)) {
////            wordPath.add(ncgPath);
////        }
//
//
//        //心电
//        EcgDTO ecg = quickMeasureDao.findEcgByPersonIdToReport(personId, startDate, endDate);
//        if (null != ecg) {
//            String ecgPath = buildEcgData(ecg, map);
//            if (StringUtil.isNotEmpty(ecgPath)) {
//                wordPath.add(ecgPath);
//            }
//        }
//        //B超报告
//        UltrasoundDTO ult = ultrasoundDao.getUltrasoundFileListByPersonIdToReport(startDate, endDate, personId);
//        if (null != ult) {
//            String bulPath = buildUltData(ult, map);
//            if (StringUtil.isNotEmpty(bulPath)) {
//                wordPath.add(bulPath);
//            }
//        }
//        //设置中医体质辨识
//        TcmDTO tcm = tcmDao.selectByPersonIdToReport(personId, startDate, endDate);
//
//        if (null != tcm) {
//            String mtId = tcm.getMtId();
//            if (StringUtil.isNotEmpty(mtId)) {
//                RestResponse response = personService.getService("201608021149347242", mtId);
//                if (response.isSuccess()) {
//                    ZlTcmDTO tcmDTO = (ZlTcmDTO) response.getData();
//                    if (null != tcmDTO) {
//                        tcm = tcmDTO.convert2TcmDTO();
//                    }
//                }
//            }
//            String tcmPath = buildTcmData(tcm, map);
//            if (StringUtil.isNotEmpty(tcmPath)) {
//                wordPath.add(tcmPath);
//            }
//        }
//
//        //健康教育
//        if (null != healthform) {
//            String education = healthform.getHealthEducation();
//            String eduPath = buildEduData(education, map);
//            if (StringUtil.isNotEmpty(eduPath)) {
//                wordPath.add(eduPath);
//            } else {
//                education = healthEducationDao.selectHealthEducationByHealthformId(healthform.getId(), region);
//                if (StringUtil.isNotEmpty(education)) {
//                    wordPath.add(eduPath);
//                }
//            }
//        }
//        String lastPath = buildLast(map);
//        if (StringUtil.isNotEmpty(lastPath)) {
//            wordPath.add(lastPath);
//        }
//
//        String uuid = UUIDUtil.getUUID();
//        String pdfPath = FileUploadUtil.getAbsoluteRoot() + "/person/render/temp/" + uuid + ".pdf";
//        Word2PdfUtil.manyDoc2pdf(wordPath, pdfPath);
//        String url = FileUploadUtil.relativePathToUrl("/person/render/temp/" + uuid + ".pdf");
//        if (StringUtil.isNotEmpty(url)) {
//            if (url.contains(config.getTagetUrl())) {
//                String nUrl = url.replaceAll(config.getTagetUrl(), config.getForwardUrl());
//                if (StringUtil.isNotEmpty(nUrl)) {
//                    url = nUrl;
//                }
//            }
//        }
//        restResponse.setData(url);
//        try {
//            if (!CollectionUtils.isEmpty(wordPath)) {
//                for (String path : wordPath) {
//                    File file = new File(path);
//                    if (file.exists()) {
//                        file.delete();
//                    }
//                }
//            }
//        } catch (Exception e) {
//
//        }
//        return restResponse;
//    }
//
//    private String buildLast(Map<String, Object> map) {
//        String lastPath = FileUploadUtil.getAbsoluteRoot() + "/person/render/template/sub/last.docx";
//        return createWord(lastPath, map);
//    }
//
//
//    /**
//     * 组装 心电 一键打印数据
//     * education
//     *
//     * @param
//     * @param map
//     */
//    private String buildEduData(String education, Map<String, Object> map) {
//        if (StringUtil.isEmpty(education)) {
//            return null;
//        }
//        map.put("education", education);
//        StringBuilder templatePath = new StringBuilder();
//        templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/healthedu.docx");
//        return createWord(templatePath.toString(), map);
//    }
//
//
//    /**
//     * 组装 lis 一键打印数据
//     *
//     * @param detectDOs
//     * @param map
//     */
//    private String buildLisData(List<LisDetectDO> detectDOs, Map<String, Object> map, Healthform healthform) {
//
//        //血常规
//        boolean xcgFlag = false;
//        boolean ncgFlag = false;
//        boolean shFlag = false;
//
//        if (null != detectDOs && detectDOs.size() > 0) {
//            for (LisDetectDO detectDO : detectDOs) {
//                if (null == detectDO) {
//                    continue;
//                }
//                if (StringUtil.isNotEmpty(detectDO.getBxb())) {
//                    map.put("leukocyte", detectDO.getBxb());
//                    map.put("leukocyteFlag", healthStand(9.5f, 3.5f, detectDO.getBxb()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getLbxbjdz())) {
//                    map.put("lbxbjdz", detectDO.getLbxbjdz());
//                    map.put("lbxbjdzFlag", healthStand(1.1f, 3.2f, detectDO.getLbxbjdz()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getZjxbsm())) {
//                    map.put("zjxbsm", detectDO.getZjxbsm());
//                    map.put("zjxbsmFlag", healthStand(0.9f, 0.1f, detectDO.getZjxbsm()));
//                }
//
//                if (StringUtil.isNotEmpty(detectDO.getLbxbbfb())) {
//                    map.put("lbxbbfb", detectDO.getLbxbbfb());
//                    map.put("lbxbbfbFlag", healthStand(50f, 20f, detectDO.getZjxbsm()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getZjxbbfb())) {
//                    map.put("zjxbbfb", detectDO.getZjxbbfb());
//                    map.put("zjxbbfbFlag", healthStand(9, 3, detectDO.getZjxbsm()));
//                }
//
//                if (StringUtil.isNotEmpty(detectDO.getHxbs())) {
//                    map.put("hxbs", detectDO.getHxbs());
//                    map.put("hxbsFlag", healthStand(5.8f, 3.8f, detectDO.getZjxbsm()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getXhdbnd())) {
//                    map.put("hemoglobin", detectDO.getXhdbnd());
//                    map.put("hemoglobinFlag", healthStand(175, 115, detectDO.getXhdbnd()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getPjhxbtj())) {
//                    map.put("pjhxbtj", detectDO.getPjhxbtj());
//                    map.put("pjhxbtjFlag", healthStand(100, 82, detectDO.getPjhxbtj()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getXxbs())) {
//                    map.put("platelet", detectDO.getXxbs());
//                    map.put("plateletFlag", healthStand(350, 125, detectDO.getXxbs()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getHxbjy())) {
//                    map.put("hxbjy", detectDO.getHxbjy());
//                    map.put("hxbjyFlag", healthStand(50, 35, detectDO.getHxbjy()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getPjhxbxhdbhl())) {
//                    map.put("pjhxbxhdbhl", detectDO.getPjhxbxhdbhl());
//                    map.put("pjhxbxhdbhlFlag", healthStand(34, 27, detectDO.getPjhxbxhdbhl()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getPjhxbxhdbnd())) {
//                    map.put("pjhxbxhdbnd", detectDO.getPjhxbxhdbnd());
//                    map.put("pjhxbxhdbndFlag", healthStand(354, 316, detectDO.getPjhxbxhdbnd()));
//                }
//
//                if (StringUtil.isNotEmpty(detectDO.getHxbtjfbkdCv())) {
//                    map.put("hxbtjfbkdcv", detectDO.getHxbtjfbkdCv());
//                    map.put("hxbtjfbkdcvFlag", healthStand(14.5f, 11.5f, detectDO.getHxbtjfbkdCv()));
//                }
//
//                if (StringUtil.isNotEmpty(detectDO.getHxbtjfbkdSd())) {
//                    map.put("hxbtjfbkdsd", detectDO.getHxbtjfbkdSd());
//                    map.put("hxbtjfbkdsdFlag", healthStand(56, 35, detectDO.getHxbtjfbkdSd()));
//                }
//
//                if (StringUtil.isNotEmpty(detectDO.getPjxxbtj())) {
//                    map.put("pjxxbtj", detectDO.getPjxxbtj());
//                    map.put("pjxxbtjFlag", healthStand(11, 7, detectDO.getPjxxbtj()));
//                }
//
//
//                if (StringUtil.isNotEmpty(detectDO.getXxbfbkd())) {
//                    map.put("xxbfbkd", detectDO.getXxbfbkd());
//                    map.put("xxbfbkdFlag", healthStand(17, 9, detectDO.getXxbfbkd()));
//                }
//
//            }
//            xcgFlag = true;
//
//
//        }
//
//
//        //尿常规从体检数据里面取
//        if (null != healthform) {
//            map.put("ketone", healthform.getKetone());
//            map.put("ketoneFlag", healthStand(healthform.getKetone()));
//            map.put("occultBloodInUrine", healthform.getOccultBloodInUrine());
//            map.put("occultFlag", healthStand(healthform.getOccultBloodInUrine()));
//            map.put("urine", healthform.getUrine());
//            map.put("urineFlag", healthStand(healthform.getUrine()));
//            map.put("urineProtein", healthform.getUrineProtein());
//            map.put("urineProteinFlag", healthStand(healthform.getUrineProtein()));
//        }
//
//
//        if (null != detectDOs && detectDOs.size() > 0) {
//            //生化
//            shFlag = true;
//            for (LisDetectDO detectDO : detectDOs) {
//                if (StringUtil.isNotEmpty(detectDO.getBasajzym())) {
//                    map.put("serumAla", detectDO.getBasajzym());
//                    map.put("serumAlaFlag", healthStand(40, 0, detectDO.getBasajzym()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getTmdasajzym())) {
//                    map.put("serumAa", detectDO.getTmdasajzym());
//                    map.put("serumAaFlag", healthStand(34, 0, detectDO.getTmdasajzym()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getZdhs())) {
//                    map.put("totalBilirubin", detectDO.getZdhs());
//                    map.put("totalBilirubinFlag", healthStand(20.1f, 5, detectDO.getZdhs()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getXns())) {
//                    map.put("bun", detectDO.getXns());
//                    map.put("bunFlag", healthStand(8.2f, 2.82f, detectDO.getXns()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getJg())) {
//                    map.put("serumCreatinine", detectDO.getJg());
//                    map.put("serumCreatinineFlag", healthStand(133, 50, detectDO.getJg()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getPtt())) {
//                    map.put("fastingBloodGlucose", detectDO.getPtt());
//                    map.put("fastingBloodGlucoseFlag", healthStand(6.11f, 3.86f, detectDO.getPtt()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getPtt())) {
//                    map.put("fastingBloodGlucose", detectDO.getPtt());
//                    map.put("fastingBloodGlucoseFlag", healthStand(6.11f, 3.86f, detectDO.getPtt()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getGysz())) {
//                    map.put("triglycerides", detectDO.getGysz());
//                    map.put("triglyceridesFlag", healthStand(1.81f, 0.4f, detectDO.getGysz()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getZdgc())) {
//                    map.put("totalCholesterol", detectDO.getZdgc());
//                    map.put("totalCholesterolFlag", healthStand(6.1f, 3.1f, detectDO.getZdgc()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getGmdzdbdgc())) {
//                    map.put("hdlCholesterol", detectDO.getGmdzdbdgc());
//                    map.put("hdlCholesterolFlag", healthStand(1.89f, 1.07f, detectDO.getGmdzdbdgc()));
//                }
//                if (StringUtil.isNotEmpty(detectDO.getDmdzdbdgc())) {
//                    map.put("ldlCholesterol", detectDO.getDmdzdbdgc());
//                    map.put("ldlCholesterolFlag", healthStand(3.1f, 0f, detectDO.getDmdzdbdgc()));
//                }
//            }
//
//        }
//        StringBuilder templatePath = new StringBuilder();
//        templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/healthCheck.docx");
//        return createWord(templatePath.toString(), map);
////        switch (type) {
////            case "1":
////                if (xcgFlag) {
////                    templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/xcg.docx");
////                    return createWord(templatePath.toString(), map);
////                }
////            case "2":
////                if (ncgFlag) {
////                    templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/ncg.docx");
////                    return createWord(templatePath.toString(), map);
////                }
////            case "3":
////                if (shFlag) {
////                    templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/sh.docx");
////                    return createWord(templatePath.toString(), map);
////                }
////
////        }
////
////        return null;
//    }
//
//    /**
//     * 组装 心电 一键打印数据
//     *
//     * @param ecg
//     * @param map
//     */
//    private String buildEcgData(EcgDTO ecg, Map<String, Object> map) {
//        if (null == ecg) {
//            return null;
//        }
//        String doctorName = ecg.getDoctorName();
//        map.put("ecgDoctorName", doctorName);
//        String reDoctorName = ecg.getReviewDoctorName();
//        map.put("ecgReviewDoctorName", reDoctorName);
//        String examDate = ecg.getExamDate();
//        map.put("ecgexamDate", examDate);
//        String ecgUrl = ecg.getEcgUrl();
//        logger.info("一键打印心电地址：" + FileUploadUtil.urlToAbsPath(ecgUrl));
//        if (StringUtil.isNotEmpty(ecgUrl)) {
//            String filePath = FileUploadUtil.urlToAbsPath(ecgUrl);
//            File file = new File(filePath);
//            if (!file.exists()) {
//                logger.error("心电图片不存在");
//                return null;
//            }
//            BufferedImage image = getImage(FileUploadUtil.urlToAbsPath(ecgUrl));
//            if (null == image&&file.exists()) {
//                map.put("ecgpath", new PictureRenderData(760, 454, filePath));
//            } else {
//                map.put("ecgpath", new PictureRenderData(760, 454, ".png", BytePictureUtils.getBufferByteArray(image)));
//            }
//            String ecgData = ecg.getEcgData();
//            //设置默认值
//            map.put("speed", "25mm/ms");
//            map.put("sensitivity", "15mm/mV");
//            String ecgException = ecg.getEcgResult();
//            map.put("ecgResult", ecgException);
//            if (StringUtil.isNotEmpty(ecgData)) {
//                ecgData = ecgData.replaceAll("RESULT", "");
//                try {
//                    logger.error("一键打印心电数据:" + ecgData);
//                    JSONObject jsonObject = JSON.parseObject(ecgData);
//                    if (null != jsonObject) {
//                        String result = jsonObject.getString("result");
//                        String arr[] = result.split(";");
//                        if (null != arr && arr.length > 1) {
//                            String ecgResult = arr[0];
//                            if (StringUtil.isEmpty(ecgException)) {
//                                map.put("ecgResult", ecgResult);
//                            }
//                            String other[] = arr[1].split("\n");
//                            if (null != other && other.length > 0) {
//                                for (int i = 0; i < other.length; i++) {
//                                    String str = other[i];
//                                    if (StringUtil.isNotEmpty(str) && str.contains(":")) {
//                                        String[] sub = str.split(":");
//                                        if (null != sub && sub.length > 1) {
//                                            String subStr = sub[0];
//                                            switch (subStr) {
//                                                case "心率":
//                                                    map.put("ecgxl", sub[1]);
//                                                case "电轴":
//                                                    map.put("ecgdz", sub[1]);
//                                                case "Rv5":
//                                                    map.put("Rv5", sub[1]);
//                                                case "QTc":
//                                                    map.put("QTc", sub[1]);
//                                                case "P波时限":
//                                                    map.put("ecgp", sub[1]);
//                                                case "QRS时限":
//                                                    map.put("ecgq", sub[1]);
//                                                case "Sv1":
//                                                    map.put("Sv1", sub[1]);
//                                                case "P-R间期":
//                                                    map.put("ecgpr", sub[1]);
//                                                case "Q-T间期":
//                                                    map.put("ecgqt", sub[1]);
//                                                case "R+S":
//                                                    map.put("ecgrs", sub[1]);
//                                            }
//                                        }
//                                    }
//
//                                }
//                            }
//                        }
//                        String speed = jsonObject.getString("speed");
//                        if (StringUtil.isNotEmpty(speed) && !"null".equals(speed)) {
//                            map.put("speed", speed);
//                        }
//                        String sensitivity = jsonObject.getString("sensitivity");
//                        if (StringUtil.isNotEmpty(sensitivity) && !"null".equals(sensitivity)) {
//                            map.put("sensitivity", sensitivity);
//                        }
//                    }
//                } catch (Exception e) {
//                    logger.error("解析心电数据异常:", e);
//                }
//
//            }
//            StringBuilder templatePath = new StringBuilder();
//            templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/ecg.docx");
//            return createWord(templatePath.toString(), map);
//        }
//        return null;
//    }
//
//
//    /**
//     * 组装 B超 一键打印数据
//     *
//     * @param ult
//     * @param map
//     */
//    private String buildUltData(UltrasoundDTO ult, Map<String, Object> map) {
//        if (null == ult) {
//            return null;
//        }
//        logger.error("B超图片路径：" + FileUploadUtil.urlToAbsPath(ult.getPngUrl()));
//        String filePath = FileUploadUtil.urlToAbsPath(ult.getPngUrl());
//        File file = new File(filePath);
//        if (!file.exists()) {
//            logger.error("B超图片不存在");
//            return null;
//        }
//        BufferedImage image = getImage(FileUploadUtil.urlToAbsPath(filePath));
//        if (null == image&&file.exists()) {
//            map.put("bulPath", new PictureRenderData(640, 905, filePath));
//            StringBuilder templatePath = new StringBuilder();
//            templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/bul.docx");
//            return createWord(templatePath.toString(), map);
//        } else {
//            map.put("bulPath", new PictureRenderData(640, 905, ".png", BytePictureUtils.getBufferByteArray(image)));
//            StringBuilder templatePath = new StringBuilder();
//            templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/bul.docx");
//            return createWord(templatePath.toString(), map);
//        }
//
//    }
//
//
//    /**
//     * 组装中医体质辨识一键打印数据
//     *
//     * @param tcm
//     * @param map
//     */
//    private String buildTcmData(TcmDTO tcm, Map<String, Object> map) {
//        if (null == tcm) {
//            return null;
//        }
//        map.put("tz", tcm.getTz());
//        map.put("pptz", tcm.getPptz());
//        map.put("tzBehave", tcm.getTzBehave());
//        map.put("tzIllnessTrend", tcm.getTzIllnessTrend());
//        map.put("riskCtrl", tcm.getRiskCtrl());
//        map.put("qzts", tcm.getQzts());
//        map.put("ysty", tcm.getYsty());
//        map.put("qjts", tcm.getQjts());
//        map.put("ydbj", tcm.getYdbj());
//        String path = tcm.getAcupointMap();
//        if (StringUtil.isNotEmpty(path)) {
//            int charAt = path.lastIndexOf("/");
//            logger.error("穴位图地址：" + ACUPOINT_MAP_PATH + path.substring(charAt + 1));
//            map.put("source", new PictureRenderData(446, 362, ACUPOINT_MAP_PATH + path.substring(charAt + 1)));
//        }
//        map.put("other", tcm.getOther());
//        StringBuilder templatePath = new StringBuilder();
//        templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/tcm.docx");
//        return createWord(templatePath.toString(), map);
//    }
//
//
//    private String buildPersonData(PersonDO personDO, DoctorDTO doctorDTO, Map<String, Object> map) {
//        if (null == personDO) {
//            return null;
//        }
//        map.put("personNo", personDO.getPersonCode());
//        map.put("name", personDO.getName());
//        map.put("year", DateUtils.date2Str(new Date()).substring(0, 4));
//        map.put("personTel", personDO.getPersonTel());
//        map.put("cardId", personDO.getCardId());
//        map.put("address", personDO.getCurrentAddress());
//        map.put("gender", Gender.getDescriptionByCode(personDO.getGenderCode()));
//        map.put("age", DateUtils.computAge(null, personDO.getCardId(), personDO.getBirthday()));
//        map.put("orgNmae", doctorDTO.getOrgName());
//        StringBuilder templatePath = new StringBuilder();
//        templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/index.docx");
//        return createWord(templatePath.toString(), map);
//
//
//    }
//
//
//    private void buildHealthCommonData2(Healthform healthform, Map<String, Object> map) {
//        if (null != healthform) {
//            map.put("height", healthform.getHeight());
//            map.put("weight", healthform.getWeight());
//            map.put("bmi", healthform.getBmi());
//            map.put("bmiFlag", healthStand(23.9f, 18.5f, healthform.getBmi()));
//            map.put("waistline", healthform.getWaistline());
//            map.put("waistlineFlag", healthStand(130f, 70f, healthform.getWaistline()));
//            map.put("leftEye", healthform.getLeftEye());
//            map.put("leftEyeFlag", healthStand(5.0f, 4.0f, healthform.getLeftEye()));
//            map.put("rightEye", healthform.getRightEye());
//            map.put("rightEyeFlag", healthStand(5.0f, 4.0f, healthform.getRightEye()));
//            map.put("leftSbp", healthform.getLeftSbp());
//            map.put("leftSbpFlag", healthStand(140f, 90f, healthform.getLeftSbp()));
//            map.put("leftDbp", healthform.getLeftDbp());
//            map.put("leftDbpFlag", healthStand(90f, 60f, healthform.getLeftDbp()));
//            map.put("rightSbp", healthform.getRightSbp());
//            map.put("rightSbpFlag", healthStand(140f, 90f, healthform.getRightSbp()));
//            map.put("rightDbp", healthform.getRightDbp());
//            map.put("rightDbpFlag", healthStand(90, 60f, healthform.getRightDbp()));
//            map.put("responsibleDoctorName", healthform.getResponsibleDoctorName());
//        }
//
//    }
//
//    private String healthStand(String val) {
//        if (StringUtil.isEmpty(val)) {
//            return null;
//        }
//        if (val.contains("+")) {
//            return "阳性";
//        }
//        return null;
//    }
//
//    private String healthStand(float max, float min, String val) {
//        if (StringUtil.isEmpty(val)) {
//            return null;
//        }
//        if (!StringUtil.isNumber(val)) {
//            return null;
//        }
//        float value = Float.valueOf(val);
//        if (value > max) {
//            return "↑";
//        }
//        if (value < min) {
//            return "↓";
//        }
//        return null;
//    }
//
//    private String buildHealthResultData(String jsonStr, Map<String, Object> map) {
//        if (StringUtil.isNotEmpty(jsonStr)) {
//            List<Map<String, Object>> healthResultDOS = handResult(jsonStr);
//            if (healthResultDOS != null && healthResultDOS.size() > 0) {
//                map.put("healthResult", healthResultDOS);
//                StringBuilder templatePath = new StringBuilder();
//                templatePath.append(FileUploadUtil.getAbsoluteRoot()).append("/person/render/template/sub/healthResult.docx");
//                return createWord(templatePath.toString(), map);
//            }
//        }
//        return null;
//    }
//
//
//    private String createWord(String path, Map<String, Object> map) {
//        String uuid = UUIDUtil.getUUID();
//        String wordPath = FileUploadUtil.getAbsoluteRoot() + "/person/render/template/word/" + uuid + ".docx";
//        try {
//            XWPFTemplate.compile(path, renderConfigure).render(map).writeToFile(wordPath);
//        } catch (IOException e) {
//            logger.error("创建word失败", e);
//            return null;
//        }
//        return wordPath;
//    }
//
//
//    private List<Map<String, Object>> handResult(String str) {
//        List<HealthResultDO> healthResultDOS = new ArrayList<>();
//        List<Map<String, Object>> list = new ArrayList<>();
//        JSONObject object = JSON.parseObject(str);
//        JSONObject data = object.getJSONObject("data");
//        Map<String, Object> map = data.getInnerMap();
//        int i = 0;
//        for (String key : map.keySet()) {
//            String subStr = JSON.toJSONString(map.get(key));
//            if (!JSON.isValidObject(subStr)) {
//                continue;
//            }
//            JSONObject sub = (JSONObject) map.get(key);
//            String suggestion = (String) sub.get("suggestion");
//            if (StringUtil.isNotEmpty(suggestion)) {
//                HealthResultDO resultDO = new HealthResultDO();
//                StringBuilder exceptionBuilder = new StringBuilder();
//                boolean flag = false;
//                Map<String, Object> subMap = sub.getInnerMap();
//                for (String subKey : subMap.keySet()) {
//                    Object o3 = subMap.get(subKey);
//                    if (null != o3) {
//                        if (!JSON.isValidObject(JSON.toJSONString(o3))) {
//                            continue;
//                        }
//                        Map<String, Object> l3 = JSON.parseObject(JSON.toJSONString(o3), Map.class);
//                        if (null == l3) {
//                            continue;
//                        }
//                        String result = (String) l3.get("result");
//                        if (StringUtil.isNotEmpty(result) && !result.equals("正常")) {
//                            flag = true;
//                        }
//                        //心电图结果值为数字不合并
//                        if (!result.contains("心电图")) {
//                            exceptionBuilder.append(l3.get("item")).append(result).append(":").append(l3.get("value")).append(";");
//                        }
//                        logger.info("{}{}:{};", l3.get("item"), result, l3.get("value"));
//                    }
//                }
//                if (flag) {
//                    resultDO.setSuggestion(suggestion);
//                    String header = EXCEPTION + ++i + "：";
//                    exceptionBuilder.insert(0, header);
//                    resultDO.setException(exceptionBuilder.toString());
//                    healthResultDOS.add(resultDO);
//                }
//            }
//
//        }
//        if (!CollectionUtils.isEmpty(healthResultDOS)) {
//            for (HealthResultDO resultDO : healthResultDOS) {
//                Map<String, Object> subMap = new HashMap<>();
//                subMap.put("exception", resultDO.getException());
//                subMap.put("suggestion", resultDO.getSuggestion());
//                list.add(subMap);
//            }
//        }
//        return list;
//
//    }
//
//    private static BufferedImage getImage(String path) {
//        String str = Base64Utils.imageToBase64ByLocal(path);
//        BASE64Decoder decoder = new BASE64Decoder();
//        try {
//            ByteArrayInputStream in = new ByteArrayInputStream(decoder.decodeBuffer(str));
//            BufferedImage image = ImageIO.read(in);
//            return image;
//        } catch (IOException e) {
//            logger.error("图片读取异常", e);
//        }
//        return null;
//    }
//
//
//    public static void main(String[] args) {
//
//
//        String uuid = UUIDUtil.getUUID();
//        String wordPath = "E:\\一键打印\\心电\\" + uuid + ".docx";
//        Map<String, Object> map = new HashMap<>();
//        String bulUrl = "E:\\一键打印\\1650339349204011960602204190194.png";
//        BufferedImage image = getImage(bulUrl);
//        ConfigureBuilder builder = Configure.newBuilder();
//        builder.buildGramer("${", "}");
//        HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();
//        builder.bind("healthResult", policy);
//        Configure renderConfigure = builder.build();
//        image = null;
//        if (null == image) {
//            map.put("ecgpath", new PictureRenderData(666, 800, bulUrl));
//
//        } else {
//            map.put("ecgpath", new PictureRenderData(666, 800, ".png", BytePictureUtils.getBufferByteArray(image)));
//        }
//        try {
//            String tempPath = "E:\\一键打印\\template\\bul.docx";
//            XWPFTemplate.compile(tempPath, renderConfigure).render(map).writeToFile(wordPath);
//        } catch (IOException e) {
//            logger.error("创建word失败", e);
//
//        }
//    }
//
//}
