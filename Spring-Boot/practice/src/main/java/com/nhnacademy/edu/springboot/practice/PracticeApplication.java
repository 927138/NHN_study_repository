package com.nhnacademy.edu.springboot.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PracticeApplication {

     public static void main(String[] args) {
          // static method
//		SpringApplication.run(StudentApplication.class, args);

          //construct
          SpringApplication application = new SpringApplication(PracticeApplication.class);
          application.run(args);

     }

}
