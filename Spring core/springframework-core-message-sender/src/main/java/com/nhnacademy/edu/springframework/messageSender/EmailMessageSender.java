package com.nhnacademy.edu.springframework.messageSender;

public class EmailMessageSender implements MessageSender{

     public EmailMessageSender(){
          System.out.println("Email Class call");
     }
     @Override
     public void sendMessage(User user, String message) {
          System.out.println("Email send message  "+ user.getEmail() + " : " + message);
     }
}
