package com.nhnacademy.edu.springboot.practice.account.controller;

import com.nhnacademy.edu.springboot.practice.account.domain.Account;
import com.nhnacademy.edu.springboot.practice.account.service.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

     private final AccountService accountService;

     @GetMapping("/accounts")
     public List<Account> getAccounts(){
          return accountService.getAccounts();
     }

     @GetMapping("/account/{id}")
     public Account getAccount(@PathVariable("id") Long id){
          return accountService.getAccount(id);
     }

     @PostMapping("/account")
     @ResponseStatus(HttpStatus.CREATED)
     public Account createAccount(@RequestBody Account account){
          return accountService.createAccount(account);
     }

     @DeleteMapping("/account/{id}")
     public String deleteAccount(@PathVariable("id") Long id){
          accountService.deleteAccount(id);
          return "{\"result\":\"OK\"}";
     }

}
