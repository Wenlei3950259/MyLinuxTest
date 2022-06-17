//package com.demo.config.util;
//
//import com.deepoove.poi.XWPFTemplate;
//import com.deepoove.poi.config.Configure;
//import com.deepoove.poi.config.ConfigureBuilder;
//import com.deepoove.poi.render.Render;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Component
//public class MyPoiUtil {
//    @Autowired
//    private Configure renderConfigure;
//    @PostConstruct
//    public void initRenderConfigure() {
//        ConfigureBuilder builder = Configure.newBuilder();
//        builder.buildGramer("${", "}");
//        renderConfigure = builder.build();
//    }
//
//}
