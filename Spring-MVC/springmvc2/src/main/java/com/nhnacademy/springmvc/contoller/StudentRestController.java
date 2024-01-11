package com.nhnacademy.springmvc.contoller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentRequest;
import com.nhnacademy.springmvc.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
     private final StudentRepository studentRepository;

     public StudentRestController(StudentRepository studentRepository) {
          this.studentRepository = studentRepository;
     }

     @PostMapping("/students")
     @ResponseStatus(HttpStatus.CREATED)
     public Student createStudent(@RequestBody StudentRequest studentsRequest) {

          return studentRepository.studentRegister(studentsRequest.getName(), studentsRequest.getEmail(),
                  studentsRequest.getScore(), studentsRequest.getComment());
     }

     @GetMapping("/students/{studentId}")
     public ResponseEntity<Student> handle(@PathVariable("studentId") long id) {

          if (!studentRepository.exists(id)) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          }

          Student student = studentRepository.getStudent(id);
          return ResponseEntity.status(HttpStatus.OK).body(student);
     }


     @PutMapping("/students/{studentId}")
     public ResponseEntity<Student> postStudentMethod(@PathVariable("studentId") long id,
                                                      @RequestBody StudentRequest studentsRequest) {

          if (!studentRepository.exists(id)) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          }

          Student student = studentRepository.getStudent(id);
          student.setName(studentsRequest.getName());
          student.setEmail(studentsRequest.getEmail());
          student.setScore(studentsRequest.getScore());
          student.setComment(studentsRequest.getComment());

          return ResponseEntity.status(HttpStatus.CREATED).body(student);
     }


}
