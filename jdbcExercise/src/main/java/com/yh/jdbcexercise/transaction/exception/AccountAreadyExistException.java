package com.yh.jdbcexercise.transaction.exception;

public class AccountAreadyExistException extends RuntimeException {
     public AccountAreadyExistException(long accountNumber) {
          super("account aready exist accountNumber : "+ accountNumber );
     }
}