package com.example.demo3.servlet;

import com.example.demo3.dto.Student;
import java.util.List;

public interface StudentRepository {

     void save(Student student);
     void update(Student student);
     void deleteById(String id);
     Student getStudentById(String id);
     List<Student> getStudents();
     boolean existById(String id);
}
