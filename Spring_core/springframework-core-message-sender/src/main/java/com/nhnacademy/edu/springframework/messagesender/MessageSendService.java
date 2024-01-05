package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSendService {
     private final MessageSender messageSender;

     @Autowired
     public MessageSendService(@Qualifier("doorayMessageSender") MessageSender messageSender){
          this.messageSender = messageSender;
     }

     public boolean doSendMessage(User user, String message){
          boolean senderFlag = messageSender.sendMessage(user, message);

          return senderFlag;
     }
}
