package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Student;

public interface StudentRepository {

     boolean exists(long id);
     Student getStudent(long id);
     Student studentRegister(String name, String email, int score, String comment);
     void studentModify(Student student);
}
