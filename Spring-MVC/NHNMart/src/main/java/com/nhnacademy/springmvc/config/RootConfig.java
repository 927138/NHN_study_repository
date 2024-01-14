package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.Base;
import com.nhnacademy.springmvc.domain.Category;
import com.nhnacademy.springmvc.domain.Inquiry;
import com.nhnacademy.springmvc.repository.CustomerRepository;
import com.nhnacademy.springmvc.repository.CustomerRepositoryImp;
import com.nhnacademy.springmvc.repository.InquiryRepository;
import com.nhnacademy.springmvc.repository.InquiryRepositoryImp;
import java.text.SimpleDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {

     @Bean
     public CustomerRepository userRepository() {
          CustomerRepository customerRepository = new CustomerRepositoryImp();
          customerRepository.addCustomer("user", "123");
          customerRepository.adminCreate("admin", "123", "test");

          return customerRepository;
     }

     @Bean
     public InquiryRepository inquiryRepository(){
          return new InquiryRepositoryImp();
     }
}
