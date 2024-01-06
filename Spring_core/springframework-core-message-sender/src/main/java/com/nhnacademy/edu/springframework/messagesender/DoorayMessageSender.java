package com.nhnacademy.edu.springframework.messagesender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.domain.User;

public class DoorayMessageSender implements MessageSender{

     private final DoorayHookSender hookSender;

     public DoorayMessageSender(DoorayHookSender hookSender){
          this.hookSender = hookSender;
     }
     @Override
     public boolean sendMessage(User user, String message){
          hookSender.send(DoorayHook.builder()
                          .botName("hello")
                          .text("hello")
                          .build());
          return true;
     }
}
