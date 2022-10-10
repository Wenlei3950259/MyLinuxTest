package com.demo;

import com.demo.controller.TestCrateTableController;
import com.demo.service.impl.TestCrateTableServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.demo.mapper")
@MapperScan("com.demo.config.redis.RedisConfig")
public class MybatisXApplication {
    private final static Logger logger = LoggerFactory.getLogger(MybatisXApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MybatisXApplication.class, args);
    }

}
