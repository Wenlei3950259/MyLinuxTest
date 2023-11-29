package com.demo.mtqqtest;


import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @Author : wenL
 * @create 2023/11/29 11:20
 */
public class MqttSample {
    public static void main(String[] args) {
        String topic = "test";
        String content = "去你妈的";
        int qos = 0;
        String broker = "mqtts://uc5148ac.ala.cn-hangzhou.emqxsl.cn:8883";
        String clientId = "mqttx_ad99427f";
        //  持久化
        MemoryPersistence persistence = new MemoryPersistence();
        // MQTT 连接选项
        MqttConnectOptions connOpts = new MqttConnectOptions();
        // 设置认证信息
        connOpts.setUserName("wen");
        connOpts.setPassword("123".toCharArray());

        // ssl/tls 配置
        try {
//             broker = "ssl://uc5148ac.ala.cn-hangzhou.emqxsl.cn:8883";
//
////             单向ssl/tls
//             String caCrtFile = MqttSample.class.getResource("").getPath() + "./uc5148ac.ala.cn-hangzhou.emqxsl.cn";
//             connOpts.setSocketFactory(SSLUtils.getSingleSocketFactory(caCrtFile));

            // 双向ssl/tls
            // String caCrtFile = MqttSample.class.getResource("").getPath() + "./server-ca.crt";
            // String crtFile = MqttSample.class.getResource("").getPath() + "./client.crt";
            // String keyFile = MqttSample.class.getResource("").getPath() + "./client.key";
            // connOpts.setSocketFactory(SSLUtils.getSocketFactory(caCrtFile, crtFile, keyFile, ""));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            MqttClient client = new MqttClient(broker, clientId, persistence);
            // 设置回调
            client.setCallback(new SampleCallback());
            // 建立连接
            System.out.println("Connecting to broker: " + broker);
            client.connect(connOpts);
            System.out.println("Connected to broker: " + broker);
            // 订阅 topic
            client.subscribe(topic, qos);
            System.out.println("Subscribed to topic: " + topic);
            // 发布消息
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            client.publish(topic, message);
            System.out.println("Message published");
            client.disconnect();
            System.out.println("Disconnected");
            client.close();
            System.exit(0);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
}
