package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class StudentRepositoryImp implements StudentRepository{

     private final Map<Long, Student> repository =  new HashMap<>();

     @Override
     public boolean exists(long id) {
          return repository.containsKey(id);
     }

     @Override
     public Student getStudent(long id) {
          return exists(id) ? repository.get(id) : null;
     }

     @Override
     public Student studentRegister(String name, String email, int score, String comment) {
          long id = repository.keySet().stream()
                  .max(Comparator.comparing(Function.identity()))
                  .map(l -> l + 1)
                  .orElse(1L);

          Student student = new Student(name, email, score, comment);
          student.setId(id);
          repository.put(id, student);

          return student;
     }

     @Override
     public void studentModify(Student student) {
          Student dbStudent = getStudent(student.getId());
          if(Objects.isNull(dbStudent))
               throw new StudentNotFoundException();

          dbStudent.setName(student.getName());
          dbStudent.setEmail(student.getEmail());
          dbStudent.setScore(student.getScore());
          dbStudent.setComment(student.getComment());
     }
}
