package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.demo.mapper")
public class MybatisXApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisXApplication.class, args);
    }

}
