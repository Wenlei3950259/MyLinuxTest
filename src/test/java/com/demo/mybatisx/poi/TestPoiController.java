package com.demo.mybatisx.poi;


import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.config.ConfigureBuilder;
import com.demo.mybatisx.dto.HealthDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.FileOutputStream;

public class TestPoiController {


    @Autowired
    private Configure renderConfigure;
    private static String dataPath = "F:\\changhong\\mydemo\\mybatisX\\src\\main\\resources\\templates\\health_notice_template.docx";

    private static String outPath = "F:\\changhong\\mydemo\\mybatisX\\src\\main\\resources\\templates\\output.docx";




    public void Login() throws Exception {
        HealthDTO healthDTO = new HealthDTO();
        healthDTO.setOrgName("11231");
        healthDTO.setBmi("1");
        healthDTO.setExamD("2");
        healthDTO.setExamM("3");
        healthDTO.setHeight("4");

        XWPFTemplate template = XWPFTemplate.compile(dataPath, renderConfigure).render(healthDTO);

        FileOutputStream out = new FileOutputStream(outPath);
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }


    public static void main(String[] args) {
        try {
            TestPoiController testPoiController = new TestPoiController();
            testPoiController.Login();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
