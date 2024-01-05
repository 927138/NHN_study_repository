package com.nhnacademy.edu.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@PropertySource("classpath:doorayUriPath.properties")
@EnableAspectJAutoProxy
public class MainConfig {
}
