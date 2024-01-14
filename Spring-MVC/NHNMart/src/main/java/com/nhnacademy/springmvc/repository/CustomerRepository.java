package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Customer;

public interface CustomerRepository {
     boolean exists(String id);
     boolean matches(String id, String password);
     Customer getCustomer(String id);
     Customer addCustomer(String id, String password);
     Customer addCustomer(String id, String password, String name);
     void modifyCustomer(Customer customer);
     Customer adminCreate(String id, String password, String name);
}
