package com.demo.controller;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.config.ConfigureBuilder;
import com.demo.dto.HealthDTO;
import com.demo.service.PoiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.util.Map;

@RestController
@Api(value = "poi")
public class PoiTlController {

    @Autowired
    private PoiService poiService;

    private static String dataPath = "F:\\changhong\\mydemo\\mybatisX\\src\\main\\resources\\templates\\health_notice_template.docx";

    private static String outPath = "F:\\changhong\\mydemo\\mybatisX\\src\\main\\resources\\templates\\output.docx";


    @PostMapping("/down")
    public void down() {
        poiService.down();

    }
}
