package com.nhnacademy.edu.springframework.config;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.aop.TimeLoggingAdvice;
import com.nhnacademy.edu.springframework.messagesender.DoorayMessageSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSendService;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:doorayUrlPath.properties")
@EnableAspectJAutoProxy
public class JavaConfig {

     @Value("${hookUrl}")
     private String hookurl;

     @Bean("doorayHookSender")
     public DoorayHookSender hookSender(){
          return new DoorayHookSender(new RestTemplate(), hookurl);
     }

     @Bean("doorayMessageSender")
     public DoorayMessageSender messageSender(DoorayHookSender hookSender){
          return new DoorayMessageSender(hookSender);
     }

     @Bean("messageSendService")
     public MessageSendService sendService(MessageSender messageSender){
          return new MessageSendService(messageSender);
     }

     @Bean("timeLogging")
     public TimeLoggingAdvice timeLoggingAdvice(){
          return new TimeLoggingAdvice();
     }
}
