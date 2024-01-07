package com.nhnacademy.edu.springframework.messagesender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.annotation.HookSendMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorayHookSenderBean {
     @Value("${hookUrl}")
     private String hookUrl;

     @HookSendMessage
     public void sendHook(){
          new DoorayHookSender(new RestTemplate(), hookUrl)
                  .send(DoorayHook.builder()
                          .botName("test")
                          .text("pass")
                          .build());
     }

}
