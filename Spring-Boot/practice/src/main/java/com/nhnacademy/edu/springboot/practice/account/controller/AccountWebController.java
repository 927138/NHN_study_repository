package com.nhnacademy.edu.springboot.practice.account.controller;

import com.nhnacademy.edu.springboot.practice.account.service.AccountService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class AccountWebController {

     private final AccountService service;

     @GetMapping("/web/accounts/{id}")
     public String getAccount(@PathVariable("id") Long id, Model model){
          model.addAttribute("account",service.getAccount(id));
          return "home";
     }
}
