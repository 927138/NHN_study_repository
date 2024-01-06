package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.domain.User;
import org.springframework.stereotype.Component;


@Component
public class DoorayMessageSender implements MessageSender{

     private DoorayHookSenderBean hookBean;

     public DoorayMessageSender(DoorayHookSenderBean hookBean){
          this.hookBean = hookBean;
     }

     @Override
     public boolean sendMessage(User user, String message){
          hookBean.sendHook();

          return true;
     }
}
