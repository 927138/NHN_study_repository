package com.nhnacademy.springmvc.contoller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class NowController {

     @GetMapping("/now")
     public String now(String name, ModelMap model) {
          model.addAttribute("time", new Date().toString());
          return "now";
     }

}
