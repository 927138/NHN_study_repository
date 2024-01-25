package com.nhnacademy.edu.springboot.practice.account.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.practice.account.domain.Account;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {
     @Autowired
     private MockMvc mockMvc;

     @Test
     @Order(1)
     void testPostAccounts() throws Exception {
          ObjectMapper mapper = new ObjectMapper();
          Account account = new Account(1L, "name", "number", 10000);

          mockMvc.perform(post("/accounts")
                          .content(mapper.writeValueAsString(account))
                          .contentType(MediaType.APPLICATION_JSON))
                  .andExpect(status().isCreated())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                  .andExpect(jsonPath("$.name", equalTo("name")));
     }

     @Test
     @Order(2)
     void testGetAccount() throws Exception{
          mockMvc.perform(get("/accounts"))
                  .andExpect(status().isOk())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                  .andExpect(jsonPath("$[0].name", equalTo("name")));
     }

     @Test
     @Order(3)
     void testDeleteAccount() throws Exception{
          mockMvc.perform(delete("/accounts/{id}", 1L))
                  .andExpect(status().isOk())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                  .andExpect(jsonPath("$.result", equalTo("OK")));
     }
}