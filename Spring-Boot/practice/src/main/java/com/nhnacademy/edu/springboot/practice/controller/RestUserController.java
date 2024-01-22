package com.nhnacademy.edu.springboot.practice.controller;


import com.nhnacademy.edu.springboot.practice.domain.UserPasswordModifyRequest;
import com.nhnacademy.edu.springboot.practice.domain.UserRegisterRequest;
import com.nhnacademy.edu.springboot.practice.entity.User;
import com.nhnacademy.edu.springboot.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestUserController {

     private final UserService userService;

     @GetMapping("/user/{userId}")
     public ResponseEntity<User> getUser(@PathVariable("userId") String id){
          return ResponseEntity.ok(userService.getUser(id));
     }

     @PostMapping("/user")
     public ResponseEntity<User> postUserRegister(@RequestBody UserRegisterRequest userRegisterRequest){
          return ResponseEntity.ok(userService.userRegister(userRegisterRequest));
     }

     @PutMapping("/user/{userId}")
     public ResponseEntity<User> putUserModify(@PathVariable("userId") String id,
                                               @RequestBody UserPasswordModifyRequest modifyRequest){
          return ResponseEntity.ok(userService.userPasswordModify(id, modifyRequest));
     }

     @DeleteMapping("/user/{userId}")
     public ResponseEntity<User> deleteUser(@PathVariable("userId") String id){
          userService.userDelete(id);
          return ResponseEntity.ok().build();
     }

}
