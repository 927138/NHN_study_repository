package com.nhnacademy.edu.springboot.practice.controller;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
     @GetMapping
     public String urlLogout(HttpServletRequest request){
          HttpSession session = request.getSession();
          if(Objects.isNull(session.getAttribute("checkedLogin")))
               return "loginForm";

          session.invalidate();
          return "redirect:/login";
     }

     @PostMapping
     public String formLogout(HttpServletRequest request){
          HttpSession session = request.getSession();
          if(Objects.isNull(session.getAttribute("checkedLogin")))
               return "loginForm";

          session.invalidate();
          return "redirect:/login";
     }

}