package com.nhnacademy.springjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcSetCheckController {
     @GetMapping("/")
     public String getSettingCheckView(){
          return "home";
     }
}
