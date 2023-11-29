package com.demo.controller;

import com.demo.config.mqtt.MqttSendClient;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author : wenL
 * @create 2023/11/29 9:12
 */
@RestController
@Api(value = "mqtt")
public class MqttController {
    @Resource
    private MqttSendClient mqttSendClient;

    @GetMapping(value = "/publishTopic")
    public String publishTopic(String topic, String sendMessage) {
        System.out.println("topic:" + topic);
        System.out.println("message:" + sendMessage);
        this.mqttSendClient.publish(false, topic, sendMessage);
        return "topic:" + topic + "\nmessage:" + sendMessage;
    }
}
