package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.annotation.Means;
import com.nhnacademy.edu.springframework.annotation.MessageQualifier;
import com.nhnacademy.edu.springframework.annotation.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MessageSendService {
     private MessageSender messageSender;

//     public MessageSendService(){
//           System.out.println("default construct");
//      }

     public MessageSendService(@Qualifier("doorayMessageSender") MessageSender messageSender){
          this.messageSender = messageSender;
//          System.out.println("--------- @SMS injection");
     }
     public void doSendMessage(User user, String message){
          messageSender.sendMessage(user, message);
     }
}
