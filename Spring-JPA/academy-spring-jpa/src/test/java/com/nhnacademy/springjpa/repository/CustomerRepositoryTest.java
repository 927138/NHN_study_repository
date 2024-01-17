package com.nhnacademy.springjpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.Customer;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})

class CustomerRepositoryTest {

     @PersistenceContext
     EntityManager entityManager;

     @Autowired
     private CustomerRepository customerRepository;

     @Test
     void existsByCustomerId(){

          boolean existsTrueResult = customerRepository.existsByCustomerId(1L);
          boolean existsFalseResult = customerRepository.existsByCustomerId(2L);

          assertThat(existsTrueResult).isTrue();
          assertThat(existsFalseResult).isFalse();

     }

     @Test
     void findByCustomerId(){
          Customer customer = Optional.of(customerRepository
                          .findByCustomerId(1L))
                          .orElse(null);

          assertThat(customer).isNotNull();

          Optional<Customer> result = Optional.ofNullable(customerRepository
                  .findByCustomerId(2L));
          assertThat(result).isEmpty();
     }

     @Test
     void findByAllSelect(){
          List<Customer> customers = customerRepository.findAllBy();
          assertEquals(1, customers.size());
     }

}