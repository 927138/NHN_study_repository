package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.Base;
import com.nhnacademy.springmvc.repository.StudentRepository;
import com.nhnacademy.springmvc.repository.StudentRepositoryImp;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {

     @Bean
     public StudentRepository studentRepository(){
          StudentRepository studentRepository = new StudentRepositoryImp();
          studentRepository.studentRegister("admin", "123@gmail.com", 60, "good job");

          return studentRepository;
     }

     @Bean
     public MessageSource messageSource(){
          ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
          messageSource.setDefaultEncoding("UTF-8");
          messageSource.setBasename("message");

          return messageSource;
     }
}
