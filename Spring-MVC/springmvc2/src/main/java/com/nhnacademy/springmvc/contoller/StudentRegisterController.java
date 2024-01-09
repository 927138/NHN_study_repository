package com.nhnacademy.springmvc.contoller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentRequest;
import com.nhnacademy.springmvc.repository.StudentRepository;
import com.nhnacademy.springmvc.repository.StudentRepositoryImp;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student/register")
public class StudentRegisterController {

     private final StudentRepository repository;

     public StudentRegisterController(StudentRepository studentRepository){
          this.repository = studentRepository;
     }

     @GetMapping
     public String getStudentRegister() {
          return "studentRegister";
     }

     @PostMapping
     public String postStudentRegister(@Valid  @ModelAttribute StudentRequest studentRequest,
                                     Model model){
          Student student = repository.studentRegister(studentRequest.getName(),
                  studentRequest.getEmail(), studentRequest.getScore(), studentRequest.getComment());

          System.out.println(studentRequest.getScore());
          model.addAttribute("student", student);
          return "studentView";

     }
}
