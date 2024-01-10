package com.nhnacademy.springmvc.contoller;

import com.nhnacademy.springmvc.domain.User;
import com.nhnacademy.springmvc.repository.UserRepository;
import com.sun.source.tree.UsesTree;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/login", "/"})
public class LoginController {

     private final UserRepository userRepository;

     public LoginController(UserRepository userRepository) {
          this.userRepository = userRepository;
     }

     @GetMapping
     public String init(HttpServletRequest request, Model model) {
          HttpSession session = request.getSession();

          if(!Objects.isNull(session.getAttribute("checkedLogin")) &&
               !Objects.isNull(session.getAttribute("userId"))){
               model.addAttribute("users", session.getAttribute("userId"));
          }

          return "loginForm";
     }

     @PostMapping
     public String login(@ModelAttribute User user, HttpServletRequest request,
                         Model model) {

          HttpSession session = request.getSession();

          boolean matchedUser = userRepository.matches(user.getId(), user.getPassword());
          if (matchedUser) {
               session.setAttribute("checkedLogin", "true");
               session.setAttribute("userId", user);
               model.addAttribute("users", user);
          }
          return "loginForm";
     }
}
