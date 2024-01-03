package com.nhnacademy.edu.springframework.messagesender;

public class Test {

     public static void main(String[] args) {
          User user = new User("qudwl@naver.com", "010-9342-2711");
          new MessageSendService(new SmsMessageSender()).doSendMessage(user, "hi");
     }

}
