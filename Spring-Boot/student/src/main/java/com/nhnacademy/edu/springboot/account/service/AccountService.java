package com.nhnacademy.edu.springboot.account.service;

import com.nhnacademy.edu.springboot.account.domain.Account;
import java.util.List;

public interface AccountService {
     List<Account> getAccounts();
     Account createAccount(Account account);
     Account getAccount(Integer id);
     void deleteAccount(Integer id);
}
