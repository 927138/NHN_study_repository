package com.nhnacademy.springboot.openServer.adaptor;

import com.nhnacademy.springboot.openServer.domain.Account;
import java.util.List;

public interface AccountAdaptor {
     List<Account> getAccounts();
     Account getAccount(Long id);
     Account createAccount(Account account);
     String deleteAccount(Long id);
}
