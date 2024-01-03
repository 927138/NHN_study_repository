package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.annotation.Means;
import com.nhnacademy.edu.springframework.annotation.MessageQualifier;

public class MessageSendService {
     private MessageSender messageSender;

     public void setMessageSender(MessageSender messageSender) {
          this.messageSender = messageSender;
     }

//     public void setSmsMessageSender(MessageSender messageSender){
//          this.messageSender = messageSender;
//     }

     public MessageSendService(){
           System.out.println("default construct");
      }

     public MessageSendService(@MessageQualifier(means = Means.SMS, checking = false) MessageSender messageSender){
          this.messageSender = messageSender;
          System.out.println("--------- @SMS injection");
     }
     public void doSendMessage(User user, String message){
          messageSender.sendMessage(user, message);
     }
}
