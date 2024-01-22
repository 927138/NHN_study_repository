package com.nhnacademy.edu.springboot.practice.service;

import com.nhnacademy.edu.springboot.practice.domain.StudentRequest;
import com.nhnacademy.edu.springboot.practice.entity.Student;
import com.nhnacademy.edu.springboot.practice.exception.StudentAlreadyExistsException;
import com.nhnacademy.edu.springboot.practice.exception.StudentNotFoundException;
import com.nhnacademy.edu.springboot.practice.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService{

     private final StudentRepository studentRepository;

     @Override
     public Student getStudent(Long id) {
          Optional<Student> studentOptional = studentRepository.findById(id);

          boolean present = studentOptional.isPresent();
          if(!present)
               throw new StudentNotFoundException();

          return studentOptional.get();
     }

     @Override
     public Student studentRegister(StudentRequest registerRequest) {
          Long id = studentRepository.findTopByIdOrderByIdDesc()+1L;
          boolean present = studentRepository.findById(id).isPresent();
          if(present)
               throw new StudentAlreadyExistsException();

          Student student = new Student();
          student.setId(id);
          student.setName(registerRequest.getName());
          student.setScore(registerRequest.getScore());
          student.setEmail(registerRequest.getEmail());
          student.setComment(registerRequest.getComment());

          return studentRepository.save(student);
     }

     @Override
     public Student studentModify(Long id, StudentRequest modifyRequest) {
          Optional<Student> studentOptional = studentRepository.findById(id);
          boolean present = studentOptional.isPresent();
          if(!present)
               throw new StudentNotFoundException();

          Student student = studentOptional.get();
          student.setComment(modifyRequest.getComment());
          student.setName(modifyRequest.getName());
          student.setScore(modifyRequest.getScore());
          student.setEmail(modifyRequest.getEmail());

          return studentRepository.saveAndFlush(student);
     }

     @Override
     public void studentDelete(Long id) {
          studentRepository.deleteById(id);
     }

     @Override
     public List<Student> getStudents() {
          return studentRepository.findAll();
     }
}
