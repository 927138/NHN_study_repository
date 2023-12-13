package com.yh.jdbcexercise.transaction.exception;

public class BalanceNotEnoughException extends RuntimeException {
     public BalanceNotEnoughException(long account_number) {
          super("balance not enough accountNumber : " + account_number );
     }
}
