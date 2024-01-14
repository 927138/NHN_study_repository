package com.nhnacademy.springmvc.service;

import com.nhnacademy.springmvc.domain.Customer;

public interface LoginService {
     boolean loginMatches(String id, String password);
     boolean managerCheck(String id, String password);
     Customer getCustomer(String id);
}
