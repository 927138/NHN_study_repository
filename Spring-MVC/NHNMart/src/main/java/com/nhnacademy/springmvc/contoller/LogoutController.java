package com.nhnacademy.springmvc.contoller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
     @GetMapping("/cs/logout")
     public String logout(HttpServletRequest request){
          request.getSession().invalidate();

          return "login";
     }
}
