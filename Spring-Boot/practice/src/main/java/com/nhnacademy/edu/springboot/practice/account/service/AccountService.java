package com.nhnacademy.edu.springboot.practice.account.service;


import com.nhnacademy.edu.springboot.practice.account.domain.Account;
import java.util.List;

public interface AccountService {
     List<Account> getAccounts();
     Account createAccount(Account account);
     Account getAccount(Long id);
     void deleteAccount(Long id);
}
