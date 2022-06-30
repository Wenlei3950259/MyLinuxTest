package com.demo;

import com.demo.service.impl.TestCrateTableServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.logging.Logger;

@SpringBootApplication
@MapperScan("com.demo.mapper")
@MapperScan("com.demo.config.redis.RedisConfig")
public class MybatisXApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisXApplication.class, args);
    }

}
