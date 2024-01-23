package com.nhnacademy.edu.springboot.practice.student.repository;//package com.nhnacademy.edu.springboot.student.repository;
//
import com.nhnacademy.edu.springboot.practice.student.domain.Student;
import java.util.List;

public interface StudentRepository {
     List<Student> findAll();
}
