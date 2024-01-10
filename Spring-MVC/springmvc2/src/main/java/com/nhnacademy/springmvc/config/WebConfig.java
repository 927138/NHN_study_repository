package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.contoller.ControllerBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = ControllerBase.class)
public class WebConfig implements WebMvcConfigurer {
     @Override
     public void configureViewResolvers(ViewResolverRegistry registry) {
          registry.jsp("/WEB-INF/view/", ".jsp");
     }

     @Override
     public void addViewControllers(ViewControllerRegistry registry) {

          registry.addViewController("/").setViewName("studentRegister");
     }

     @Bean
     public LocaleResolver localeResolver() {
          return new SessionLocaleResolver();
     }

     @Override
     public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(new LocaleChangeInterceptor());
     }
}
