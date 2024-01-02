package com.nhnacademy.edu.springframework.messageSender;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLTest {
     public static void main(String[] args) {

          User user = new User("qudwl@naver.com", "010-9342-2711");
          try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
               MessageSender sms1 = context.getBean("SMS", MessageSender.class);
               sms1.sendMessage(user, "test");

               MessageSender sms2 = context.getBean("SMS", MessageSender.class);
               sms2.sendMessage(user, "test");

               MessageSender email1 = context.getBean("Email", MessageSender.class);
               email1.sendMessage(user, "test");

               MessageSender email2 = context.getBean("Email", MessageSender.class);
               email2.sendMessage(user, "test");

          }
     }
}
