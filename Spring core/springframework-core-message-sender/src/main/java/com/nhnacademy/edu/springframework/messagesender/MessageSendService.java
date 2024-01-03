package com.nhnacademy.edu.springframework.messagesender;

public class MessageSendService {
     private MessageSender messageSender;

     public void setSmsMessageSender(MessageSender messageSender) {
          this.messageSender = messageSender;
     }

//     public void setSmsMessageSender(MessageSender messageSender){
//          this.messageSender = messageSender;
//     }

      public MessageSendService(){
           System.out.println("default construct");
      }
     public MessageSendService(MessageSender messageSender){
          this.messageSender = messageSender;
          System.out.println("---------injection");
     }
     public void doSendMessage(User user, String message){
          messageSender.sendMessage(user, message);
     }
}
