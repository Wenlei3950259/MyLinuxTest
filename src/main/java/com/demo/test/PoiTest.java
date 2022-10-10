package com.demo.test;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.config.ConfigureBuilder;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoiTest {

    public static void main(String[] args) throws IOException, IllegalAccessException {
        ConfigureBuilder builder = Configure.newBuilder();
        builder.buildGramer("${", "}");
        HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();
        builder.bind("healthResult", policy);
        Configure renderConfigure = builder.build();
        ClassPathResource classPathResource = new ClassPathResource("templates/health_notice_template.docx");
        System.err.println(classPathResource.exists());
        System.out.println();
        String path = classPathResource.getPath();
        System.err.println(path);
        String absolutePath = classPathResource.getFile().getAbsolutePath();
        System.err.println(absolutePath);
        Map<String, Object> models = new HashMap<>(64);
        models.put("orgName", "测试卫生院");
        models.put("name", "wenlei");
        models.put("sex", "女");
        models.put("age", "23");
        models.put("examY", "2022");
        models.put("examM", "06");
        models.put("examD", "06");
        models.put("riskCrtlWeight", "110");

        List<String> assessmentAbnormal = new ArrayList<>();
        assessmentAbnormal.add("肥胖;");
        assessmentAbnormal.add("体弱;");
        assessmentAbnormal.add("矮小;");
        String s = appendabString(assessmentAbnormal);
        models.put("assessmentAbnormal", s);


        XWPFTemplate template = XWPFTemplate.compile(absolutePath, renderConfigure).render(models);
        try {
            template.writeToFile("F:\\changhong\\mydemo\\mybatisX\\src\\main\\resources\\templates\\output.docx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String appendabString(List<String> listString) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String list : listString) {
            if (list.contains(";")) {
                String replace = list.replace(";", "。");
                stringBuilder.append(replace);
            } else {
                stringBuilder.append(list);
                stringBuilder.append("。");
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

}
