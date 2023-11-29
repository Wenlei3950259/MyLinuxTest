package com.demo.goeasy;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;

/**
 * @Author : wenL
 * @create 2023/11/29 13:52
 */
public class GoEasyDemo {
    public static void main(String[] args) {
        //新加坡rest-host：rest-singapore.goeasy.io
        GoEasy goEasy = new GoEasy("https://rest-hz.goeasy.io", "BC-3ecad43bfa8c4a8eba530a38ea2e3fbc");
        goEasy.publish("wen", "这是发消息!", new PublishListener() {
            @Override
            public void onSuccess() {
                System.out.println("Publish success.");
            }

            @Override
            public void onFailed(GoEasyError error) {
                System.out.println("Failed to Publish message, error:" + error.getCode() + " , " + error.getContent());
            }
        });
    }
}
