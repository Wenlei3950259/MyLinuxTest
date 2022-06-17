package com.demo.config.jwt;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class interceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
//拦截的页面
                .addPathPatterns("/token/test")
                .addPathPatterns("/del")
//被排除拦截的页面
                .excludePathPatterns("/user/login");
    }

}
