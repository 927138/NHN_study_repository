package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.User;
import com.nhnacademy.springmvc.exception.UserAlreadyExistsException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class UserRepositoryImp implements UserRepository {
     private final Map<String, User> userRepository = new HashMap<>();
     @Override
     public boolean exists(String id) {
          return userRepository.containsKey(id);
     }

     @Override
     public boolean matches(String id, String password) {
          return Optional.ofNullable(getUser(id))
                  .map(user->user.getPassword().equals(password))
                  .orElse(false);
     }

     @Override
     public User addUser(String id, String password) {
          if(exists(id))
               throw new UserAlreadyExistsException();

          User user = User.create(id, password);
          userRepository.put(id, user);
          return user;
     }

     @Override
     public User getUser(String id) {
          return exists(id) ? userRepository.get(id) : null;
     }

}
