package com.demo.mybatisx.redis;

import com.demo.config.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void A() throws InterruptedException {

        Object age = redisUtil.get("age");
        System.out.println(age);
    }
}
