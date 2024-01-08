package com.nhnacademy.springmvc.contoller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NowController {

     @GetMapping("/now")
     public String now(@RequestParam(name = "name") String name, ModelMap model) {
          model.addAttribute("time", new Date().toString());
          model.addAttribute("name", name);
          return "now";
     }

     @GetMapping("/now/{userId}")
     public String now(@PathVariable(name = "userId") int userId, ModelMap model) {
          model.addAttribute("time", new Date().toString());
          model.addAttribute("userId", userId);
          return "now";
     }
}
