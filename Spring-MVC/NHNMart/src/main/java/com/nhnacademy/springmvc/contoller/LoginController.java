package com.nhnacademy.springmvc.contoller;

import com.nhnacademy.springmvc.domain.Customer;
import com.nhnacademy.springmvc.repository.CustomerRepository;
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
@RequestMapping("/cs")
public class LoginController {

     private final CustomerRepository customerRepository;

     public LoginController(CustomerRepository customerRepository) {
          this.customerRepository = customerRepository;
     }

     @GetMapping("/login")
     public String loginForm(HttpServletRequest request, Model model){
          HttpSession session = request.getSession();

          if(!Objects.isNull(session.getAttribute("checkedLogin")) &&
                  !Objects.isNull(session.getAttribute("cusId"))){
               String id = (String) session.getAttribute("cusId");
               model.addAttribute("customer", customerRepository.getCustomer(id));
          }

          return "login";
     }

     @PostMapping("/login")
     public String login(@ModelAttribute("cus") Customer customer, Model model,
                         HttpServletRequest request){
          HttpSession session = request.getSession();
          if(customerRepository.matches(customer.getId(), customer.getPassword())){
               session.setAttribute("checkedLogin", "true");
               session.setAttribute("cusId", customer.getId());
               model.addAttribute("customer", customer);
          }
          return "login";
     }
}
