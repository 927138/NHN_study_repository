package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSendService {
     private final MessageSender messageSender;

     public MessageSendService(MessageSender messageSender){
          this.messageSender = messageSender;
     }

     public boolean doSendMessage(User user, String message){
          boolean senderFlag = messageSender.sendMessage(user, message);

          return senderFlag;
     }
}
