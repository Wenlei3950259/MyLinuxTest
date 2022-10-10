package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.net.URLDecoder;

@RestController
@RequestMapping("/TestExcel")
public class Down {
    @GetMapping(value = "/downloadTemplate")
    public void downFrozenTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = "mac.xlsx";
        ServletOutputStream out;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        //文件在项目中的存放路径
        String filePath = getClass().getResource("/templates/mac.xlsx").getPath();
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE浏览器的处理：
            fileName = new String((fileName).getBytes("UTF-8"), "ISO-8859-1");
        }
        filePath = URLDecoder.decode(filePath, "UTF-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        FileInputStream inputStream = new FileInputStream(filePath);
        out = response.getOutputStream();
        int b = 0;
        byte[] buffer = new byte[1024];
        while ((b = inputStream.read(buffer)) != -1) {
            //写到输出流(out)中
            out.write(buffer, 0, b);
        }
        inputStream.close();
        if (out != null) {
            out.flush();
            out.close();
        }
    }
}
