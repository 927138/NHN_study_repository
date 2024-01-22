package com.nhnacademy.edu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		// static method
//		SpringApplication.run(StudentApplication.class, args);

		//construct
		SpringApplication application = new SpringApplication(StudentApplication.class);
//		application.setBanner();
		application.run(args);

	}

}
