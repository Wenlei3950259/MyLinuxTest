package com.demo.controller;

import com.demo.dto.RestResponseDTO;
import com.demo.dto.TestCrateTableDTO;
import com.demo.service.FtService;
import com.demo.service.GoService;
import com.demo.service.TestCrateTableService;
import io.swagger.annotations.Api;
import me.chanjar.weixin.common.service.WxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableScheduling
@Api(value = "微信推送消息")
public class WxController {
    private final static Logger logger = LoggerFactory.getLogger(WxController.class);

    @Autowired(required = false)
    GoService goService;

    @GetMapping("/wx")
    //每天早上8点
    @Scheduled(cron = "0 00 08 * * ?")
    public void send() {
        goService.send();
    }

}
