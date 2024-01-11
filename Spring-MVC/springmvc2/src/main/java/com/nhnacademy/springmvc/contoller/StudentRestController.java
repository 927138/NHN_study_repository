package com.nhnacademy.springmvc.contoller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentRequest;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import org.springframework.http.HttpStatus;
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
     public Student getStudentMethod(@PathVariable("studentId") long id) {

          if (!studentRepository.exists(id)) {
               throw new StudentNotFoundException();
          }

          return studentRepository.getStudent(id);
     }

     @PutMapping("/students/{studentId}")
     public Student postStudentMethod(@PathVariable("studentId") long id,
                                      @RequestBody StudentRequest studentsRequest) {

          if (!studentRepository.exists(id)) {
               throw new StudentNotFoundException();
          }

          Student student = studentRepository.getStudent(id);

          student.setName(studentsRequest.getName());
          student.setEmail(studentsRequest.getEmail());
          student.setScore(studentsRequest.getScore());
          student.setComment(studentsRequest.getComment());

          return student;
     }

}
