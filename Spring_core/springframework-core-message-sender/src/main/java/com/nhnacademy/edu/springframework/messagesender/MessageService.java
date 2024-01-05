package com.nhnacademy.edu.springframework.messagesender;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageService {
     private List<MessageSender> list;
     private final User user = new User("test@email.com", "123-123");

     @Autowired
     public MessageService(List<MessageSender> list){
          this.list = list;
     }

     public void servicePrint(){
          list.stream().forEach(service -> service.sendMessage(user, "성공"));
     }
}
