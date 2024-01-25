package com.nhnacademy.edu.springboot.practice.student.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.practice.student.domain.Student;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.discovery.SelectorResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

     @Autowired
     private MockMvc mockMvc;

     @Test
     @Order(1)
     void testGetStudents() throws Exception {
          mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                  .andExpect(status().isOk())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                  .andExpect(jsonPath("$[0].name", equalTo("Manty")));
     }

     @Test
     @Order(1)
     void testGetStudents1() throws Exception{
          mockMvc.perform(MockMvcRequestBuilders.get("/students/{id}", 1L))
                  .andExpect(status().isOk())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                  .andExpect(jsonPath("$[0].name", equalTo("manty")));
     }


     @Test
     @Order(3)
     void testCreateStudent() throws Exception{
          ObjectMapper objectMapper = new ObjectMapper();
          Student zbum = new Student( "zbum1", 100);
          mockMvc.perform(post("/students")
                          .content(objectMapper.writeValueAsString(zbum))
                          .contentType(MediaType.APPLICATION_JSON))
                  .andExpect(status().isCreated())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                  .andExpect(jsonPath("$.name", equalTo("zbum1")));
     }



}
