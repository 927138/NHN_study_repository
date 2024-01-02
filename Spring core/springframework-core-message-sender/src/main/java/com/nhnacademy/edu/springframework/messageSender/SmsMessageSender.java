package com.nhnacademy.edu.springframework.messageSender;

public class SmsMessageSender implements MessageSender{


     public SmsMessageSender(){
          System.out.println("SMS class call");
     }

     @Override
     public void sendMessage(User user, String message){
          System.out.println("SMS sender Message  " + user.getPhoneNumber() + " : " + message);
     }
}
