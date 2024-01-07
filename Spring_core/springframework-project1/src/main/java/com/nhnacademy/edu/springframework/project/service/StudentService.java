package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Student;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
     Collection<Student> getPassedStudents();

     Collection<Student> getStudentsOrderByScore();
}
