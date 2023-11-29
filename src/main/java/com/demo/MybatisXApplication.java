package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.mapper")
@MapperScan("com.demo.config.redis.RedisConfig")
public class MybatisXApplication {
    private final static Logger logger = LoggerFactory.getLogger(MybatisXApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MybatisXApplication.class, args);
    }

}
