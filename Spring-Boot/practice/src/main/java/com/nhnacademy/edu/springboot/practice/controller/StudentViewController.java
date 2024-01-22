package com.nhnacademy.edu.springboot.practice.controller;

import com.nhnacademy.edu.springboot.practice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StudentViewController {

     private final StudentRepository studentRepository;

     @GetMapping("/student/view")
     public String allView(Model model){
          model.addAttribute("studentList", studentRepository.findAll());

          return "studentsView";
     }
}
