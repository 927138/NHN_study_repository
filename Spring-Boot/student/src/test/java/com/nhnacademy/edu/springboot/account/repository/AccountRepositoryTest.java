package com.nhnacademy.edu.springboot.account.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.edu.springboot.account.domain.Account;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountRepositoryTest {

     @Autowired
     AccountRepository accountRepository;

     @Test
     void test(){
          Account account = new Account(1, "ee", 50);
          accountRepository.save(account);

          Optional<Account> actual = accountRepository.findById(1);

     }
}