package com.nhnacademy.edu.springboot.practice.account.controller;

import com.nhnacademy.edu.springboot.practice.account.management.HealthIndicatorCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthIndicateRest {

     private final HealthIndicatorCustom custom;

     @PostMapping("/management/fail")
     public ResponseEntity<HealthIndicatorCustom> post(){
          custom.setCheck(true);
          return ResponseEntity.ok(custom);
     }
}
