package com.nhnacademy.springboot.openServer.service;

import com.nhnacademy.springboot.openServer.domain.Account;
import java.util.List;

public interface AccountService {

     List<Account> getAccounts();
     Account getAccount(Long id);
     Account createAccount(Account account);
     String deleteAccount(Long id);

}
