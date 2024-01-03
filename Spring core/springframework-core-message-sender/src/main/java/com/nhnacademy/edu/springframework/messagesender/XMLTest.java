package com.nhnacademy.edu.springframework.messagesender;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLTest {
     public static void main(String[] args) {

          User user = new User("qudwl@naver.com", "010-9342-2711");
          try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
               MessageSender sms1 = context.getBean("sms", MessageSender.class);
               sms1.sendMessage(user, "test");

               MessageSender sms2 = context.getBean("sms", MessageSender.class);
               sms2.sendMessage(user, "test");

               MessageSender email1 = context.getBean("email", MessageSender.class);
               email1.sendMessage(user, "test");

               MessageSender email2 = context.getBean("email", MessageSender.class);
               email2.sendMessage(user, "test");

               System.out.println("=--=-=-=-=-=-");
               MessageSendService service = context.getBean("service", MessageSendService.class);
               service.doSendMessage(user, "test");

//               System.out.println("=--=-=-=-=-=-");
//               MessageSendService service2 = context.getBean("service2", MessageSendService.class);
//               service2.doSendMessage(user, "test");

               System.out.println("=--=-=-=-=-=-");
               MessageSendService service3 = context.getBean("messageSendService", MessageSendService.class);
               service3.doSendMessage(user, "test");
          }
     }
}
