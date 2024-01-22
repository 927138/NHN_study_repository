package com.nhnacademy.edu.springboot.practice.service;

import com.nhnacademy.edu.springboot.practice.domain.StudentModifyRequest;
import com.nhnacademy.edu.springboot.practice.domain.StudentRegisterRequest;
import com.nhnacademy.edu.springboot.practice.entity.Student;

public interface StudentService {
     Student getStudent(Long id);
     Student studentRegister(StudentRegisterRequest registerRequest);
     Student studentModify(Long id, StudentModifyRequest modifyRequest);
     void studentDelete(Long id);

}
