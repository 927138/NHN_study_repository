package com.nhnacademy.edu.springboot.practice.account.service;

import com.nhnacademy.edu.springboot.practice.account.domain.Account;
import com.nhnacademy.edu.springboot.practice.account.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SpringBootApplication
public class NhnAccountService implements AccountService{

     private final AccountRepository accountRepository;

     @Override
     public List<Account> getAccounts() {
          return accountRepository.findAll();
     }

     @Override
     public Account createAccount(Account account) {
          Account account1 = new Account();
          account1.setId(account.getId());
          account1.setNumber(account.getNumber());
          account1.setBalance(account.getBalance());

          return accountRepository.save(account1);
     }

     @Override
     public Account getAccount(Long id) {
          boolean a = accountRepository.findById(id).isPresent();
          // TODO : error catch

          return accountRepository.findById(id).get();
     }

     @Override
     public void deleteAccount(Long id) {
          accountRepository.deleteById(id);
     }
}
