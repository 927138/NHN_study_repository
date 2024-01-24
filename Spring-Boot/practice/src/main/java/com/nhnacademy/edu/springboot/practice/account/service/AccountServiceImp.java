package com.nhnacademy.edu.springboot.practice.account.service;

import com.nhnacademy.edu.springboot.practice.account.domain.Account;
import com.nhnacademy.edu.springboot.practice.account.exception.AccountAlreadyExistsException;
import com.nhnacademy.edu.springboot.practice.account.exception.AccountNotFoundException;
import com.nhnacademy.edu.springboot.practice.account.repository.AccountRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService{

     private final AccountRepository accountRepository;

     @Override
     public List<Account> getAccounts() {
          return accountRepository.findAll();
     }

     @Override
     public Account createAccount(Account account) {
          Optional<Account> optionalAccount = accountRepository.findById(account.getId());
          boolean present = optionalAccount.isPresent();
          if(present)
               throw new AccountAlreadyExistsException("Account already exist by Id : " + account.getId());

          Account account1 = new Account(
                  account.getId(), account.getName(), account.getNumber(), account.getBalance()
          );

          return accountRepository.save(account1);
     }

     @Override
     public Account getAccount(Long id) {
          Optional<Account> optionalAccount = accountRepository.findById(id);
          boolean present = optionalAccount.isPresent();
          if(!present)
               throw new AccountNotFoundException("Account Not Found id :" + id);

          return optionalAccount.get();
     }

     @Override
     public void deleteAccount(Long id) {
          if(!accountRepository.existsById(id))
               throw new AccountNotFoundException("Account Not Found id :" + id);
          accountRepository.deleteById(id);
     }
}
