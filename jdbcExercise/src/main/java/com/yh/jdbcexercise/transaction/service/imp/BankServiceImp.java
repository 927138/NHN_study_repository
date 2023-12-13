package com.yh.jdbcexercise.transaction.service.imp;

import com.yh.jdbcexercise.transaction.domain.Account;
import com.yh.jdbcexercise.transaction.exception.AccountAreadyExistException;
import com.yh.jdbcexercise.transaction.exception.AccountNotFoundException;
import com.yh.jdbcexercise.transaction.exception.BalanceNotEnoughException;
import com.yh.jdbcexercise.transaction.repository.AccountRepository;
import com.yh.jdbcexercise.transaction.service.BankService;
import java.sql.Connection;
import java.util.Optional;

public class BankServiceImp implements BankService {

     private AccountRepository repository;

     public BankServiceImp(AccountRepository accountRepository){
          this.repository = accountRepository;
     }

     @Override
     public Account getAccount(Connection connection, long accountNumber) {
          Optional<Account> accountOptional = repository.findByAccountNumber(connection, accountNumber);
          if(accountOptional.isEmpty()){
               throw new AccountNotFoundException(accountNumber);
          }return accountOptional.get();
     }

     @Override
     public void createAccount(Connection connection, Account account) {
          if(isExistAccount(connection,account.getAccountNumber())){
               throw new AccountAreadyExistException(account.getAccountNumber());
          }

          int result = repository.save(connection, account);
          if(result < 1){
               throw new RuntimeException("Do not Save Account");
          }
     }

     @Override
     public boolean depositAccount(Connection connection, long accountNumber, long amount) {
          if(!isExistAccount(connection, accountNumber)){
               throw new AccountNotFoundException(accountNumber);
          }

          int result = repository.deposit(connection,accountNumber, amount);
          return result>0;
     }

     @Override
     public boolean withdrawAccount(Connection connection, long accountNumber, long amount) {
          //todo 출금, 계좌가 존재하는지 체크 ->  출금가능여부 체크 -> 출금실행
          if(!isExistAccount(connection, accountNumber)){
               throw new AccountNotFoundException(accountNumber);
          }

          Optional<Account> accountOptional = repository.findByAccountNumber(connection,accountNumber);
          Account account = accountOptional.get();

          if( !account.isWithdraw(amount) ) {
               //잔액부족 예외처리
               throw new BalanceNotEnoughException(accountNumber);
          }

          int result = repository.withdraw(connection,accountNumber,amount);
          return result>0;
     }

     @Override
     public void transferAmount(Connection connection, long accountNumberFrom, long accountNumberTo, long amount) {
          //todo 계좌 이체 accountNumberFrom -> accountNumberTo 으로 amount만큼 이체

          //계좌체크
          if(!isExistAccount(connection,accountNumberFrom)){
               throw new AccountNotFoundException(accountNumberFrom);
          }
          if(!isExistAccount(connection,accountNumberTo)){
               throw new AccountNotFoundException(accountNumberTo);
          }

          Optional<Account> accountFromOptional = repository.findByAccountNumber(connection,accountNumberFrom);
          if(accountFromOptional.isEmpty()){
               throw new AccountNotFoundException(accountNumberFrom);
          }

          Optional<Account> accountToOptional = repository.findByAccountNumber(connection,accountNumberTo);
          if(accountToOptional.isEmpty()){
               throw new AccountNotFoundException(accountNumberTo);
          }

          Account accountFrom = accountFromOptional.get();

          if(!accountFrom.isWithdraw(amount)){
               throw new BalanceNotEnoughException(accountNumberFrom);
          }

          int result1 = repository.withdraw(connection,accountNumberFrom,amount);

          if(result1<1){
               throw new RuntimeException("fail - withdraw :" + accountNumberFrom );
          }

          int result2 = repository.deposit(connection,accountNumberTo,amount);

          if(result2 <1){
               throw new RuntimeException("fail - deposit : " + accountNumberTo);
          }
     }

     @Override
     public boolean isExistAccount(Connection connection, long accountNumber) {
          int count = repository.countByAccountNumber(connection, accountNumber);
          return count > 0;
     }

     @Override
     public void dropAccount(Connection connection, long accountNumber) {
          if(!isExistAccount(connection,accountNumber)){
               throw new AccountNotFoundException(accountNumber);
          }
          int result = repository.deleteByAccountNumber(connection,accountNumber);
          if(result<1){
               throw new RuntimeException("fail-dropAccount:" + accountNumber);
          }
     }
}
