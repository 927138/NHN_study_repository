package com.example.demo3.servlet;

import com.example.demo3.dto.Student;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MapStudentRepository implements StudentRepository{

     private final static Map<String, Student> studentMap = new ConcurrentHashMap<>();

     @Override
     public void save(Student student) {
          studentMap.put(student.getId(), student);
     }

     @Override
     public void update(Student student) {
          studentMap.put(student.getId(), student);
     }

     @Override
     public void deleteById(String id) {
          studentMap.remove(id);
     }

     @Override
     public Student getStudentById(String id) {
          return studentMap.get(id);
     }

     @Override
     public List<Student> getStudents() {
          return studentMap.values()
                  .stream()
                  .collect(Collectors.toList());
     }

     @Override
     public boolean existById(String id) {
          return false;
     }
}
