package com.nhnacademy.springboot.openServer.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties("spring.profiles.active")
public class UrlConfigProperties {
     private String ip;
     private String port;

     public String getAddress(){
          return "http:/" + ip + ":" + port;
     }
}
