package com.nhnacademy.edu.springboot.practice.controller;

import com.nhnacademy.edu.springboot.practice.domain.StudentRequest;
import com.nhnacademy.edu.springboot.practice.entity.Student;
import com.nhnacademy.edu.springboot.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestStudentController {

     private final StudentService studentService;

     @GetMapping("/students/{userId}")
     public ResponseEntity<Student> getStudent(@PathVariable("userId") Long id){
          return ResponseEntity.ok(studentService.getStudent(id));
     }

     @PostMapping("/students")
     public ResponseEntity<Student> postStudentRegister(@RequestBody StudentRequest registerRequest){
          return ResponseEntity.ok(studentService.studentRegister(registerRequest));
     }

     @PutMapping("/students/{studentId}")
     public ResponseEntity<Student> putStudentModify(@PathVariable("studentId") Long id,
                                               @RequestBody StudentRequest modifyRequest){
          return ResponseEntity.ok(studentService.studentModify(id, modifyRequest));
     }

     @DeleteMapping("/students/{studentId}")
     public ResponseEntity<Student> deleteStudent(@PathVariable("studentId") Long id){
          studentService.studentDelete(id);
          return ResponseEntity.ok().build();
     }

}
