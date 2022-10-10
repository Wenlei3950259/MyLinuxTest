package com.demo.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
@Api("文件操作")
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

//    @ApiOperation("文件上传")
//    @PostMapping("/upload")
//    public void uploadFile(@RequestParam("file") MultipartFile file) {
//        long startTime = System.currentTimeMillis();
//        String path = "";
//        String originalFilename = file.getOriginalFilename();
//        logger.info("fileName：" + originalFilename);
//        int lastIndexOf = originalFilename.lastIndexOf(".");
//        String fileType = originalFilename.substring(lastIndexOf + 1);
//        //文件类型判断 doc,docx,jpg,png,xls
//        logger.info("截取文件名类型:{}", fileType);
//        if (fileType.equals("jpg") || fileType.equals("png") || fileType.equals("dox") || fileType.equals("docx") || fileType.equals("xls")) {
//            path = "F:/changhong/" + new Date().getTime() + originalFilename;
//            File newFile = new File(path);
//            //通过CommonsMultipartFile的方法直接写文件(注意这个时候）
//            try {
//                file.transferTo(newFile);
//                long endTime = System.currentTimeMillis();
//                logger.info("采用file.Transto的运行时间：" + String.valueOf(endTime - startTime) + "ms");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            throw new LogicException("类型不行");
//        }
//    }
//    @ApiOperation("文件删除")
//    @PostMapping("/del")
//    public void deleteFile(String file) {
//        File testFile = new File(file);
//        if (testFile.exists()) {
//            testFile.delete();
//        }
//    }
}
