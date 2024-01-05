package com.nhnacademy.edu.springframework.messagesender;

import static org.mockito.Mockito.when;

import com.nhnacademy.edu.springframework.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DoorayMessageSenderTest {

     @Mock
     private MessageSender messageSender;

     @InjectMocks
     private MessageSendService sendService;

     @BeforeEach
     public void init(){
          MockitoAnnotations.initMocks(this);
     }

     @Test
     void sendMessage() {
          when(messageSender.sendMessage(new User("123", "213"), "test"))
                  .thenReturn(false);

          boolean actual = sendService.doSendMessage(new User("123", "213"), "test");

          Assertions.assertThat(actual).isEqualTo(false);
     }
}