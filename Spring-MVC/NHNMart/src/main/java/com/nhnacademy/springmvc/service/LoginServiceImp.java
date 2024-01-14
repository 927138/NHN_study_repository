package com.nhnacademy.springmvc.service;

import com.nhnacademy.springmvc.domain.Customer;
import com.nhnacademy.springmvc.domain.Role;
import com.nhnacademy.springmvc.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImp implements LoginService{
     private final CustomerRepository customerRepository;

     @Override
     public boolean loginMatches(String id, String password) {
          return customerRepository.matches(id, password);
     }

     @Override
     public boolean managerCheck(String id, String password) {

          if(!customerRepository.matches(id, password))
               return false;
          if(Role.ADMIN != customerRepository.getCustomer(id).getRole())
               return false;
          return true;
     }

     @Override
     public Customer getCustomer(String id) {
          return customerRepository.getCustomer(id);
     }
}
