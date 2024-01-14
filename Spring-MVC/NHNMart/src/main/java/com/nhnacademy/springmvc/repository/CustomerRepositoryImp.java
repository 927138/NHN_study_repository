package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Customer;
import com.nhnacademy.springmvc.domain.Role;
import com.nhnacademy.springmvc.exception.CustomerAlreadyExistsException;
import com.nhnacademy.springmvc.exception.CustomerNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class CustomerRepositoryImp implements CustomerRepository{

     private final Map<String, Customer> repository = new HashMap<>();

     @Override
     public boolean exists(String id) {
          return repository.containsKey(id);
     }

     @Override
     public boolean matches(String id, String password) {
          return Optional.ofNullable(getCustomer(id))
                  .map(cus -> cus.getPassword().equals(password))
                  .orElse(false);
     }

     @Override
     public Customer getCustomer(String id) {
          return exists(id) ? repository.get(id) : null;
     }

     @Override
     public Customer addCustomer(String id, String password) {
          return addCustomer(id, password, "unknown");
     }

     @Override
     public Customer adminCreate(String id, String password, String name) {
          if(exists(id))
               throw new CustomerAlreadyExistsException();

          Customer admin = Customer.createUser(id);
          admin.setPassword(password);
          admin.setName(name);
          admin.setRole(Role.ADMIN);
          repository.put(id, admin);
          return admin;
     }

     @Override
     public Customer addCustomer(String id, String password, String name) {
          if(exists(id))
               throw new CustomerAlreadyExistsException();

          Customer customer = Customer.createUser(id);
          customer.setPassword(password);
          customer.setName(name);

          repository.put(id, customer);
          return customer;
     }

     @Override
     public void modifyCustomer(Customer customer) {
          Customer storageCustomer = repository.get(customer.getId());
          if(Objects.isNull(storageCustomer))
               throw new CustomerNotFoundException();

          storageCustomer.setPassword(customer.getPassword());
          storageCustomer.setName(customer.getName());
     }
}
