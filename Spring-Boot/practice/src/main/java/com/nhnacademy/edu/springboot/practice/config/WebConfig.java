package com.nhnacademy.edu.springboot.practice.config;

import com.nhnacademy.edu.springboot.practice.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
     @Override
     public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(new LoginCheckInterceptor())
                  .excludePathPatterns("/login", "/", "/students", "/students/*", "/users", "/users/*");
     }
}
