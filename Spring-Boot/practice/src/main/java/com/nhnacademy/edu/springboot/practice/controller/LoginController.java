package com.nhnacademy.edu.springboot.practice.controller;

import com.nhnacademy.edu.springboot.practice.entity.User;
import com.nhnacademy.edu.springboot.practice.repository.UserRepository;
import com.nhnacademy.edu.springboot.practice.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping({"/login", "/"})
public class LoginController {
     private final UserService userService;
     private final String USER_ID = "userId";

     @GetMapping
     public String init(HttpServletRequest request, Model model) {
          HttpSession session = request.getSession();

          if(!Objects.isNull(session.getAttribute("checkedLogin")) &&
                  !Objects.isNull(session.getAttribute(USER_ID))){
               model.addAttribute("users", session.getAttribute(USER_ID));
          }

          return "loginForm";
     }

     @PostMapping
     public String login(@ModelAttribute User user, HttpServletRequest request,
                         Model model) {

          HttpSession session = request.getSession();

          boolean matchedUser = userService.matches(user.getId(), user.getPassword());
          if (matchedUser) {
               session.setAttribute("checkedLogin", "true");
               session.setAttribute(USER_ID, user);
               model.addAttribute("users", user);
          }
          return "loginForm";
     }
}
