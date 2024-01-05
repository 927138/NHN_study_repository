package com.nhnacademy.edu.springframework.messagesender;

import org.springframework.stereotype.Component;

@Component
public class EmailMessageSender implements MessageSender{

     public void init(){
          System.out.println("init method called in EmailMessageSender");
     }
     @Override
     public void sendMessage(User user, String message) {
          System.out.println("Email send message  "+ user.getEmail() + " : " + message);
     }
}
