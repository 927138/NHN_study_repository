package com.nhnacademy.springboot.openServer.service;

import com.nhnacademy.springboot.openServer.config.UrlConfigProperties;
import com.nhnacademy.springboot.openServer.domain.Account;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

     private final RestTemplate restTemplate;
     private final UrlConfigProperties urlConfigProperties;

     @Override
     public List<Account> getAccounts() {

          HttpEntity<String> requestEntity = new HttpEntity<>(header());
          ResponseEntity<List<Account>> exchange = restTemplate.exchange("http://localhost:8080/students",
                  HttpMethod.GET,
                  requestEntity,
                  new ParameterizedTypeReference<>() {
                  });
          return exchange.getBody();
     }

     @Override
     public Account getAccount(Long id) {

          HttpEntity<String> requestEntity = new HttpEntity<>(header());
          ResponseEntity<Account> exchange = restTemplate
                  .exchange(
                          urlConfigProperties.getAddress() + "/accounts/" + id,
                          HttpMethod.GET,
                          requestEntity,
                          new ParameterizedTypeReference<>() {}
                  );
          return exchange.getBody();
     }

     @Override
     public Account createAccount(Account account) {

          HttpEntity<Account> requestEntity = new HttpEntity<>(account, header());
          ResponseEntity<Account> exchange = restTemplate
                  .exchange(
                          urlConfigProperties.getAddress() + "/accounts",
                          HttpMethod.POST,
                          requestEntity,
                          new ParameterizedTypeReference<>() {}
                  );
          return exchange.getBody();
     }

     @Override
     public String deleteAccount(Long id) {
          HttpEntity<String> requestEntity = new HttpEntity<>(header());
          ResponseEntity<String> exchange = restTemplate
                  .exchange(
                          urlConfigProperties.getAddress() + "/accounts/"+id,
                          HttpMethod.GET,
                          requestEntity,
                          new ParameterizedTypeReference<>() {}
                  );
          return exchange.getBody();
     }

     private HttpHeaders header() {
          HttpHeaders httpHeaders = new HttpHeaders();
          httpHeaders.setContentType(MediaType.APPLICATION_JSON);
          httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

          return httpHeaders;
     }
}
