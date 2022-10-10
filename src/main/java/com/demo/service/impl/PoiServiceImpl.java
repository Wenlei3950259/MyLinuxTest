package com.demo.service.impl;

import com.demo.config.redis.RedisUtil;
import com.demo.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoiServiceImpl implements PoiService {

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void down() {
        redisUtil.expire("age", 50 * 50);

    }
}
