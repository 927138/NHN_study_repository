package com.nhnacademy.edu.springframework.messagesender;

import org.springframework.stereotype.Component;

@Component
public class SmsMessageSender implements MessageSender{


     public void init(){
          System.out.println("init method called in SmsMessageSender");
     }

     @Override
     public void sendMessage(User user, String message){
          System.out.println("SMS sender Message  " + user.getPhoneNumber() + " : " + message);
     }
}
