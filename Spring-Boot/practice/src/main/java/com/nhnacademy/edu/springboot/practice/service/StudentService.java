package com.nhnacademy.edu.springboot.practice.service;

import com.nhnacademy.edu.springboot.practice.domain.StudentRequest;
import com.nhnacademy.edu.springboot.practice.entity.Student;
import java.util.List;

public interface StudentService {

     boolean exists(Long id);
     Student getStudent(Long id);
     Student studentRegister(StudentRequest registerRequest);
     Student studentModify(Long id, StudentRequest modifyRequest);
     void studentDelete(Long id);

     List<Student> getStudents();
}
