package com.nhnacademy.springmvc.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageInterceptor {

     @GetMapping("/inter")
     public String check(){
          return "index";
     }
}
