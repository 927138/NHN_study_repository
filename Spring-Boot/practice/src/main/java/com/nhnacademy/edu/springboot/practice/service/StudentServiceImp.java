package com.nhnacademy.edu.springboot.practice.service;

import com.nhnacademy.edu.springboot.practice.domain.StudentModifyRequest;
import com.nhnacademy.edu.springboot.practice.domain.StudentRegisterRequest;
import com.nhnacademy.edu.springboot.practice.entity.Student;
import com.nhnacademy.edu.springboot.practice.exception.StudentAlreadyExistsException;
import com.nhnacademy.edu.springboot.practice.exception.StudentNotFoundException;
import com.nhnacademy.edu.springboot.practice.repository.StudentRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     public Student studentRegister(StudentRegisterRequest registerRequest) {
          boolean present = studentRepository.findById(registerRequest.getId()).isPresent();
          if(present)
               throw new StudentAlreadyExistsException();

          Student student = new Student();
          student.setId(registerRequest.getId());
          student.setName(registerRequest.getName());
          student.setScore(registerRequest.getScore());
          student.setEmail(registerRequest.getEmail());
          student.setComment(registerRequest.getComment());

          return studentRepository.save(student);
     }

     @Override
     public Student studentModify(Long id, StudentModifyRequest modifyRequest) {
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


}
