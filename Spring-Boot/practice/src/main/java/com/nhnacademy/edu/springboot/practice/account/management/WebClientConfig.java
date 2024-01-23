package com.nhnacademy.edu.springboot.practice.account.management;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebClientConfig {

     // TODO 1 : RestTemplate 타입의 빈을 선언합니다.
     @Bean
     public RestTemplate restTemplate(RestTemplateBuilder builder) {
          return builder
                  .setReadTimeout(Duration.ofSeconds(5L))
                  .setConnectTimeout(Duration.ofSeconds(3L))
                  .build();
     }
}
