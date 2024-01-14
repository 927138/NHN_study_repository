package com.nhnacademy.springmvc.contoller;

import com.nhnacademy.springmvc.domain.Customer;
import com.nhnacademy.springmvc.exception.CustomerNotFoundException;
import com.nhnacademy.springmvc.repository.CustomerRepository;
import com.nhnacademy.springmvc.service.LoginService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/cs")
@RequiredArgsConstructor
public class LoginController {

     public static final String CUS_ONJECT = "customer";
     public static final String LOGIN_SUCESSES = "login";
     private final LoginService loginService;


     @GetMapping("/login")
     public String getLogin(HttpServletRequest request, Model model){
          HttpSession session = request.getSession();

          if(!Objects.isNull(session.getAttribute(LOGIN_SUCESSES))){
               String id = (String) session.getAttribute(LOGIN_SUCESSES);
               model.addAttribute(CUS_ONJECT, loginService.getCustomer(id));
          }

          return "login";
     }

     @PostMapping("/login")
     public String postLogin(@ModelAttribute("cus") Customer customer, Model model,
                         HttpServletRequest request){
          HttpSession session = request.getSession();

          if (loginService.managerCheck(customer.getId(), customer.getPassword())) {
               session.setAttribute(LOGIN_SUCESSES, customer.getId());
               model.addAttribute(CUS_ONJECT, customer);
               return "redirect:/cs/admin";
          }

          if(loginService.loginMatches(customer.getId(), customer.getPassword())){
               session.setAttribute(LOGIN_SUCESSES, customer.getId());
               model.addAttribute(CUS_ONJECT, customer);
               return "redirect:/cs/inquiry";
          }

          throw new CustomerNotFoundException();
     }

     @GetMapping("/logout")
     public String getLogout(HttpServletRequest request){
          request.getSession().invalidate();

          return "redirect:/cs/login";
     }

     @ExceptionHandler(CustomerNotFoundException.class)
     @ResponseStatus(HttpStatus.NOT_FOUND)
     public String notFound(Exception ex, Model model){
          model.addAttribute("exception", ex);
          return "error";
     }
}
