package com.nhnacademy.edu.springboot.practice.student.repository;//package com.nhnacademy.edu.springboot.student.repository;

import com.nhnacademy.edu.springboot.practice.student.domain.Student;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DummyStudentRepository implements StudentRepository{

     @Override
     public List<Student> findAll() {
          return List.of(
                  new Student("aa" , 100),
                  new Student("bb", 80)
          );
     }
}
