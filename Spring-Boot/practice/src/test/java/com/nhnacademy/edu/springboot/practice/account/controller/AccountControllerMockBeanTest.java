package com.nhnacademy.edu.springboot.practice.account.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

import com.nhnacademy.edu.springboot.practice.account.domain.Account;
import com.nhnacademy.edu.springboot.practice.account.repository.AccountRepository;
import com.nhnacademy.edu.springboot.practice.account.service.AccountService;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class AccountControllerMockBeanTest {

     @Autowired
     private MockMvc mockMvc;

     @MockBean
     private AccountService accountService;



     @Test
     void testGetAccount() throws Exception{
          given(accountService.getAccounts())
                  .willReturn(List.of(new Account(1L, "name", "number", 1000)));

          mockMvc.perform(get("/accounts"))
                  .andExpect(status().isOk())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                  .andExpect(jsonPath("$[0].name", Matchers.equalTo("name")));
     }

     @Test
     void testPostAccount() throws Exception{

     }
}