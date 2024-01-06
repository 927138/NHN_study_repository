package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.messagesender.DoorayMessageSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSendService;
import com.nhnacademy.edu.springframework.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
     public static void main(String[] args) {
          User user = new User("123", "123123");

          AnnotationConfigApplicationContext context =
                  new AnnotationConfigApplicationContext("com/nhnacademy/edu/springframework");

          MessageSendService service = context.getBean("messageSendService", MessageSendService.class);
          service.doSendMessage(user, "pass");

     }
}