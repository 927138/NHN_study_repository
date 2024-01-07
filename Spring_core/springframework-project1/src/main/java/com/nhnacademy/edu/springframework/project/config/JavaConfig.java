package com.nhnacademy.edu.springframework.project.config;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class JavaConfig {
}
