package com.nhnacademy.edu.springboot.practice.controller;

import com.nhnacademy.edu.springboot.practice.config.SystemConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SystemController {

     private final SystemConfig systemConfig;

     @GetMapping("/system/version")
     public ResponseEntity<SystemConfig> get(){
          return ResponseEntity.ok(systemConfig);
     }
}
