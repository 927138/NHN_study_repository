package com.nhnacademy.edu.springboot.practice.service;

import com.nhnacademy.edu.springboot.practice.domain.UserPasswordModifyRequest;
import com.nhnacademy.edu.springboot.practice.domain.UserRegisterRequest;
import com.nhnacademy.edu.springboot.practice.entity.User;

public interface UserService {
     User getUser(String id);
     User userRegister(UserRegisterRequest registerRequest);
     User userPasswordModify(String id, UserPasswordModifyRequest modifyRequest);
     void userDelete(String id);
}
