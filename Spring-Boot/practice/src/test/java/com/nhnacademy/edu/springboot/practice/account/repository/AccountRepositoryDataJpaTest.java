package com.nhnacademy.edu.springboot.practice.account.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.edu.springboot.practice.account.domain.Account;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryDataJpaTest {

     @Autowired
     TestEntityManager entityManager;

     @Autowired
     AccountRepository accountRepository;

     @Test
     void testFindByName(){
          Account account = new Account(1L, "name", "num", 1000);
          entityManager.merge(account);

          Account byId = accountRepository.findById(1L).orElse(null);
//          List<Account> byName = accountRepository.findByName("name");

          assertThat(byId).isEqualTo(account);

     }

     @Test
     void testFindAll(){
          List<Account> li =List.of(new Account(1L, "name", "num", 1000), new Account(2L, "name", "num", 1000));
          // merge 만들어야함.

          List<Account> list = accountRepository.findAll();
          assertThat(li).isEqualTo(list);
     }

}