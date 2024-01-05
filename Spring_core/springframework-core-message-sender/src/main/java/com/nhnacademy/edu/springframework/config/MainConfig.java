package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.messagesender.MessageSendService;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.SmsMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@PropertySource("classpath:myinfo.properties")
@EnableAspectJAutoProxy
public class MainConfig {

//     @Autowired
//     private SenderConfig senderConfig;
//
//     @Bean
//     public MessageSendService service(){
//          System.out.println("java >> Spring bean");
//          return new MessageSendService(senderConfig.sms());
//     }
//
//     @Bean
//     public MessageSender sms(){
//          return new SmsMessageSender();
//     }


}
