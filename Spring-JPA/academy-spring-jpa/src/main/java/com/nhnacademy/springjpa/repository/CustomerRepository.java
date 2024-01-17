package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

     List<Customer> findAllBy();
     Customer findByCustomerId(Long productId);
     List<Customer> findDistinctByCustomerName(String customerName);
     boolean existsByCustomerId(Long id);

}
