package com.yh.jdbcexercise.transaction.repository;

import com.yh.jdbcexercise.transaction.domain.Account;
import java.sql.Connection;
import java.util.Optional;

public interface AccountRepository {

     Optional<Account> findByAccountNumber(Connection connection, long accountNumber);
     int save(Connection connection, Account account);
     int countByAccountNumber(Connection connection, long accountNumber);
     int deposit(Connection connection, long accountNumber, long amount);
     int withdraw(Connection connection, long accountNumber, long amount);
     int deleteByAccountNumber(Connection connection, long accountNumber);

}
