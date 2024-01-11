package com.nhnacademy.springmvc.contoller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentRequest;
import com.nhnacademy.springmvc.repository.StudentRepository;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;


class StudentRestControllerTest {

     private MockMvc mockMvc;
     private StudentRepository studentRepository;
     private ObjectMapper objectMapper = new ObjectMapper();

     @BeforeEach
     void setUp() {
          studentRepository = mock(StudentRepository.class);
          mockMvc = MockMvcBuilders
                  .standaloneSetup(new StudentRestController(studentRepository))
                  .addFilter(new CharacterEncodingFilter("UTF-8", true))
                  .build();
     }


     @Test
     @DisplayName("GET /students/{studentId} : throw error")
     void getStudentErrorMethod() throws Exception {
          mockMvc.perform(get("/students/1"))
                  .andExpect(status().isNotFound())
                  .andReturn();
     }

     @Test
     @DisplayName(" xml) GET /students/{studentId} : 학생 조회 성공")
     void getStudentMethod1() throws Exception {

          Student student = new Student("name", "hi@gamil.com", 20, "bed score");
          when(studentRepository.exists(anyLong())).thenReturn(true);
          when(studentRepository.getStudent(anyLong())).thenReturn(student);

          MvcResult result = mockMvc.perform(
                          get("/students/{studentId}", 1)
                                  .accept(MediaType.APPLICATION_XML))
                  .andExpect(status().isOk())
                  .andExpect(content().contentType(MediaType.APPLICATION_XML + ";charset=UTF-8"))
                  .andReturn();

     }

     @Test
     @DisplayName(" json) GET /students/{studentId} : 학생 조회 성공")
     void getStudentMethod2() throws Exception {

          Student student = new Student("name", "hi@gamil.com", 20, "bed score");
          when(studentRepository.exists(anyLong())).thenReturn(true);
          when(studentRepository.getStudent(anyLong())).thenReturn(student);

          MvcResult result = mockMvc.perform(
                          get("/students/{studentId}", 1)
                                  .accept(MediaType.APPLICATION_JSON))
                  .andExpect(status().isOk())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON + ";charset=UTF-8"))
                  .andReturn();

     }

     @Test
     @DisplayName("POST /students : 학생 정보 등록 성공")
     void postMethodSuccess() throws Exception {

          Map<String, Object> requestBody = new LinkedHashMap<>();
          requestBody.put("name", "name");
          requestBody.put("email", "test@email.com");
          requestBody.put("score", 20);
          requestBody.put("comment", "name");


          MvcResult mvcResult = mockMvc.perform(
                          post("/students")
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(objectMapper.writeValueAsString(requestBody)))
                  .andExpect(status().isCreated())
                  .andDo(print())
                  .andReturn();
     }

     @Test
     @DisplayName("PUT /students/{studnetId} : 학생 정보 수정 성공")
     void postStudentSuccess() throws Exception {

          long studentId = 1;
          Student existingStudent = new Student("John Doe", "john@example.com", 90, "Great student");
          StudentRequest studentRequest = new StudentRequest();

          studentRequest.setName("Updated Name");
          studentRequest.setEmail("updated@example.com");
          studentRequest.setScore(80);
          studentRequest.setComment("Updated comment");

          when(studentRepository.exists(studentId)).thenReturn(true);
          when(studentRepository.getStudent(studentId)).thenReturn(existingStudent);

          // 요청 수행 및 응답 확인
          mockMvc.perform(
                          put("/students/{studentId}", studentId)
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content(objectMapper.writeValueAsString(studentRequest))
                  )
                  .andExpect(status().isCreated())
                  .andDo(print());
     }

     @Test
     @DisplayName("PUT /students/{studnetId} : 학생 정보 수정 실패")
     void postStudentFail1() throws Exception {

          long studentId = 1;
          StudentRequest studentRequest = new StudentRequest();
          studentRequest.setName("Updated Name");
          studentRequest.setEmail("updated@example.com");
          studentRequest.setScore(80);
          studentRequest.setComment("Updated comment");

          when(studentRepository.exists(studentId)).thenReturn(false);

          mockMvc.perform(
                          put("/students/{studentId}", studentId)
                                  .contentType(MediaType.APPLICATION_JSON)
                                  .content("{\"name\":\"Updated Name\",\"email\":\"updated@example.com\",\"score\":80,\"comment\":\"Updated comment\"}")
                  )
                  .andExpect(status().isNotFound());
     }



}