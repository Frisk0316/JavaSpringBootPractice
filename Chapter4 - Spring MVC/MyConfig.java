package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class MyConfig {
    
    @Autowired
    private MyInterceptor myInterceptor;

    // still can add @Override
    // but vs code will show error
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
