package com.nhnacademy.edu.springboot.practice.student.service;//package com.nhnacademy.edu.springboot.student.service;

import com.nhnacademy.edu.springboot.practice.student.domain.Student;
import com.nhnacademy.edu.springboot.practice.student.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//
//import com.nhnacademy.edu.springboot.student.domain.Student;
//import com.nhnacademy.edu.springboot.student.repository.StudentRepository;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService{

     private final StudentRepository studentRepository;

     @Override
     public List<Student> getStudents() {
          return null;
     }
}
