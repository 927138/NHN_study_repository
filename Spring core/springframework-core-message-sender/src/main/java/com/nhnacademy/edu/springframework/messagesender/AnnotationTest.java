package com.nhnacademy.edu.springframework.messagesender;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

     private static User user = new User("test@email.com", "123-123");

     public static void main(String[] args) {
          // List DI
               try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
                    MessageService test = context.getBean("autowireTest", MessageService.class);
                    test.servicePrint();

               }
          }

}
