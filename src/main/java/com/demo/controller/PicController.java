//package com.demo.controller;
//
//import com.demo.service.FileService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@RestController
//@RequestMapping("/pic")
//public class PicController {
//    private final static Logger logger = LoggerFactory.getLogger(PicController.class);
//
//    @Autowired
//    FileService fileService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> upload(@RequestParam("media") MultipartFile file) {
//        logger.info("save file name {}", file.getOriginalFilename());
//        String filePath = fileService.saveFile(file);
//        return  new ResponseEntity<String>(filePath,HttpStatus.OK);
//    }
//
//    @GetMapping("/download")
//    public ResponseEntity<Boolean> downloadFile(HttpServletResponse response,
//                                   @RequestParam(value = "fileName") String fileName) {
//
//        Boolean result = fileService.downloadFile(response, fileName);
//        return new ResponseEntity<>(result,HttpStatus.OK);
//    }
//
//    @GetMapping("/list")
//    public ResponseEntity<List<String>> list() {
//        return new ResponseEntity<>(fileService.getFiles(),HttpStatus.CREATED);
//    }
//
//}
