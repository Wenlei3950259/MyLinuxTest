package com.demo.controller;

import com.demo.service.GoService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
@Api(value = "微信推送消息")
public class WxController {
    private final static Logger logger = LoggerFactory.getLogger(WxController.class);

    @Autowired(required = false)
    GoService goService;

    @GetMapping("/send")
    //每天早上7:30点
//    @Scheduled(cron = "0 30 07 * * ?")
    @Scheduled(fixedDelay = 3000)
    public void send() {
        goService.send();
    }

}
