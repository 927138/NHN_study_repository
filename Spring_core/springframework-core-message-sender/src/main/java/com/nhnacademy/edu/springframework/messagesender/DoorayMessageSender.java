package com.nhnacademy.edu.springframework.messagesender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class DoorayMessageSender implements MessageSender{

     @Value("${hookUri}")
     private String uri;

     @Override
     public boolean sendMessage(User user, String message){
          System.out.println("dooray test");


          new DoorayHookSender(new RestTemplate(), uri)
                  .send(DoorayHook.builder()
                          .botName("test")
                          .text("pass")
                          .build());

          return true;
     }
}
