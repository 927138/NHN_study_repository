package com.nhnacademy.springmvc.contoller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class MessageInterceptor {

     @GetMapping("/inter")
     public String check(HttpServletRequest request, HttpServletResponse response){
          return "index";
     }
}
