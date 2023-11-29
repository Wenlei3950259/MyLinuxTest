package com.demo.util;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;

/**
 * @Author : wenL
 * @create 2023/11/23 9:49
 */
public class GoEasyUtil {
    public static void main(String[] args) {

//新加坡rest-host：rest-singapore.goeasy.io
        GoEasy goEasy = new GoEasy("http://localhost:8080/", "BC-3ecad43bfa8c4a8eba530a38ea2e3fbc");
        goEasy.publish("test_channel", "Hello, GoEasy!", new PublishListener() {
            @Override
            public void onSuccess() {
                System.out.println("Publish success.");
            }

            @Override
            public void onFailed(GoEasyError error) {
                System.out.println("Failed to Publish message, error:" + error.getCode() + " , " + error.getContent());
            }
        });
        /**
         *
         *
         *  
         *
         *
         *
         *
         *
         */
    }
}
