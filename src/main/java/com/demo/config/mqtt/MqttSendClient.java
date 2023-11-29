package com.demo.config.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author : wenL
 * @create 2023/11/29 9:38
 */
@Component
public class MqttSendClient {
    private static final Logger logger = LoggerFactory.getLogger(MqttSendClient.class);

    @Resource
    private MqttSendCallBack mqttSendCallBack;

    @Resource
    private MqttProperties mqttProperties;

    public MqttClient connect() {
        MqttClient client = null;
        try {
            client = new MqttClient(mqttProperties.getHostUrl(), mqttProperties.getClientId(), new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(mqttProperties.getUsername());
            options.setPassword(mqttProperties.getPassword().toCharArray());
            options.setConnectionTimeout(mqttProperties.getTimeout());
            options.setKeepAliveInterval(mqttProperties.getKeepAlive());
            options.setCleanSession(true);
            options.setAutomaticReconnect(false);
            // 设置回调
            client.setCallback(mqttSendCallBack);
            client.connect(options);
        } catch (Exception e) {
            logger.error("MqttSendClient connect error,message:{}", e.getMessage());
            e.printStackTrace();
        }
        return client;
    }

    /**
     * 发布消息
     *
     * @param retained 是否保留
     * @param topic    主题，格式： server:${env}:report:${topic}
     * @param content  消息内容
     */
    public void publish(boolean retained, String topic, String content) {
        MqttMessage message = new MqttMessage();
        message.setQos(mqttProperties.getQos());
        message.setRetained(retained);
        message.setPayload(content.getBytes());
        MqttDeliveryToken token;
        MqttClient mqttClient = connect();
        try {
            mqttClient.publish(mqttProperties.getServerTopic(topic), message);
        } catch (MqttException e) {
            logger.error("MqttSendClient publish error,message:{}", e.getMessage());
            e.printStackTrace();
        } finally {
            disconnect(mqttClient);
            close(mqttClient);
        }
    }

    /**
     * 关闭连接
     *
     * @param mqttClient
     */
    public static void disconnect(MqttClient mqttClient) {
        try {
            if (mqttClient != null)
                mqttClient.disconnect();
        } catch (MqttException e) {
            logger.error("MqttSendClient disconnect error,message:{}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     *
     * @param mqttClient
     */
    public static void close(MqttClient mqttClient) {
        try {
            if (mqttClient != null)
                mqttClient.close();
        } catch (MqttException e) {
            logger.error("MqttSendClient close error,message:{}", e.getMessage());
            e.printStackTrace();
        }
    }
}
