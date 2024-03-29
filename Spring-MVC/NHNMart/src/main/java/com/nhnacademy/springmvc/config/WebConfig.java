package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.contoller.ControllerBase;
import com.nhnacademy.springmvc.interceptor.LoginCheckingInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = ControllerBase.class)
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware, MessageSourceAware {
     private ApplicationContext applicationContext;
     private MessageSource messageSource;

     @Override
     public void addViewControllers(ViewControllerRegistry registry) {
          registry.addViewController("/").setViewName("login");
     }

     @Override
     public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(new LoginCheckingInterceptor())
                  .excludePathPatterns("/cs/login", "/");
     }

     @Override
     public void configureViewResolvers(ViewResolverRegistry registry) {
          registry.viewResolver(thymeleafViewResolver());
     }

     @Override
     public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
          this.applicationContext = applicationContext;
     }

     @Bean
     public MultipartResolver multipartResolver() {
          CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
          multipartResolver.setMaxUploadSize(-1);

          return multipartResolver;
     }

     @Override
     public void setMessageSource(MessageSource messageSource) {
          this.messageSource = messageSource;
     }

     @Bean
     public ThymeleafViewResolver thymeleafViewResolver() {
          ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
          viewResolver.setTemplateEngine(templateEngine());
          viewResolver.setCharacterEncoding("UTF-8");
          viewResolver.setOrder(1);

          return viewResolver;
     }

     public SpringTemplateEngine templateEngine() {
          SpringTemplateEngine templateEngine = new SpringTemplateEngine();
          templateEngine.setTemplateResolver(templateResolver());
          templateEngine.setTemplateEngineMessageSource(messageSource);

          return templateEngine;
     }

     public SpringResourceTemplateResolver templateResolver() {
          SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
          templateResolver.setApplicationContext(applicationContext);
          templateResolver.setCharacterEncoding("UTF-8");
          templateResolver.setPrefix("/WEB-INF/view/");
          templateResolver.setSuffix(".html");
          templateResolver.setTemplateMode("HTML5");

          return templateResolver;
     }
}
