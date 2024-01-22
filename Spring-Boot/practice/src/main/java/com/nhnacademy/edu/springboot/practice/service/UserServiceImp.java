package com.nhnacademy.edu.springboot.practice.service;

import com.nhnacademy.edu.springboot.practice.domain.UserPasswordModifyRequest;
import com.nhnacademy.edu.springboot.practice.domain.UserRegisterRequest;
import com.nhnacademy.edu.springboot.practice.entity.User;
import com.nhnacademy.edu.springboot.practice.exception.UserAlreadyExistsException;
import com.nhnacademy.edu.springboot.practice.exception.UserNotFoundException;
import com.nhnacademy.edu.springboot.practice.repository.UserRepository;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

     private final UserRepository userRepository;

     @Override
     public User getUser(String id) {
          Optional<User> userOptional = userRepository.findById(id);

          boolean present = userOptional.isPresent();
          if(!present)
               throw new UserNotFoundException();

          return userOptional.get();
     }

     @Override
     public User userRegister(UserRegisterRequest registerRequest) {
          Optional<User> userOptional = userRepository.findById(registerRequest.getId());

          boolean present = userOptional.isPresent();
          if(present)
               throw new UserAlreadyExistsException();

          User user = new User();
          user.setId(registerRequest.getId());
          user.setPassword(registerRequest.getPassword());

          return userRepository.save(user);
     }

     @Override
     public User userPasswordModify(String id, UserPasswordModifyRequest modifyRequest) {
          Optional<User> userOptional = userRepository.findById(id);

          boolean present = userOptional.isPresent();
          if(!present)
               throw new UserNotFoundException();

          User user = userOptional.get();
          user.setPassword(modifyRequest.getPassword());
          return userRepository.saveAndFlush(user);
     }

     @Override
     public void userDelete(String id) {
          userRepository.deleteById(id);
     }

     @Override
     public boolean exists(String id) {
          return userRepository.findById(id).isPresent();
     }

     @Override
     public boolean matches(String id, String password) {
          User user = getUser(id);

          if(user.getPassword().equals(password))
               return true;
          return false;
     }
}
