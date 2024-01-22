package com.nhnacademy.edu.springboot.practice.controller;

import com.nhnacademy.edu.springboot.practice.domain.StudentRegisterRequest;
import com.nhnacademy.edu.springboot.practice.entity.Student;
import com.nhnacademy.edu.springboot.practice.service.StudentService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student/register")
public class StudentRegisterController {

     private final StudentService studentService;
     @GetMapping
     public String getStudentRegister() {
          return "studentRegister";
     }

     @PostMapping
     public String postStudentRegister(@Valid @ModelAttribute StudentRegisterRequest studentRequest,
                                       Model model){

          Student student = studentService.studentRegister(studentRequest);
          model.addAttribute("student", student);
          return "studentView";

     }
}
