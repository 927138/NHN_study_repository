package com.nhnacademy.springboot.openServer.adaptor;

import com.nhnacademy.springboot.openServer.config.UrlConfigProperties;
import com.nhnacademy.springboot.openServer.domain.Account;
import com.nhnacademy.springboot.openServer.service.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountAdaptorImp implements AccountAdaptor{

     private final AccountService accountService;

     @Override
     public List<Account> getAccounts() {
          return accountService.getAccounts();
     }

     @Override
     public Account getAccount(Long id) {
          return accountService.getAccount(id);
     }

     @Override
     public Account createAccount(Account account) {
          return accountService.createAccount(account);
     }

     @Override
     public String deleteAccount(Long id) {
          return accountService.deleteAccount(id);
     }

}
