package com.nhnacademy.edu.springboot.practice.controller;

import com.nhnacademy.edu.springboot.practice.domain.StudentModifyRequest;
import com.nhnacademy.edu.springboot.practice.entity.Student;
import com.nhnacademy.edu.springboot.practice.exception.StudentNotFoundException;
import com.nhnacademy.edu.springboot.practice.repository.StudentRepository;
import com.nhnacademy.edu.springboot.practice.service.StudentService;
import java.util.Objects;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

     private final StudentService studentService;

     @ModelAttribute("student")
     public Student getStudent(@PathVariable("studentId") long id){
          Student student = studentService.getStudent(id);
          if(Objects.isNull(student))
               throw new StudentNotFoundException();

          return student;
     }

     @GetMapping("/{studentId}")
     public String getStudentInfo(@ModelAttribute Student student, Model model){
          model.addAttribute("student", student);
          return "studentView";
     }

     @GetMapping(value = "/{studentId}", params = "hideScore")
     public String getStudentInfoHideScore(@RequestParam("hideScore") String hide,
                                           @ModelAttribute Student student, Model model){
          model.addAttribute("student", student);
          model.addAttribute("hideScore", hide);

          return "studentView";
     }

     @GetMapping("/{studentId}/modify")
     public String getStudentModify(@ModelAttribute Student student,
                                    ModelMap modelMap) {

          modelMap.addAttribute("student", student);
          return "studentModify";
     }

     @PostMapping("{studentId}/modify")
     public ModelAndView postStudentModify(@ModelAttribute Student student,
                                           @Valid @ModelAttribute StudentModifyRequest studentModifyRequest) {

          student.setName(studentModifyRequest.getName());
          student.setScore(studentModifyRequest.getScore());
          student.setComment(studentModifyRequest.getComment());
          student.setEmail(studentModifyRequest.getEmail());

          ModelAndView mav = new ModelAndView("studentView");
          mav.addObject("student", student);
          return mav;
     }

     @ExceptionHandler(StudentNotFoundException.class)
     @ResponseStatus(HttpStatus.NOT_FOUND)
     public void handleException(){}
}
