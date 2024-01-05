package com.nhnacademy.edu.springframework.messagesender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorayMessageSender implements MessageSender{
          private String uri = "https://hook.dooray.com/services/3204376758577275363/3707922642738216364/WdJUIozGSgGdnxhQnS1lSA";
          @Override
          public void sendMessage(User user, String message){
               new DoorayHookSender(new RestTemplate(), uri)
                       .send(DoorayHook.builder()
                               .botName("지영훈")
                               .text("안녕하세요.")
                               .build());
//               System.out.println("dfsdfsdf");
     }
}
