package com.nhnacademy.edu.springboot.practice.account.exception;

public class AccountNotFoundException extends RuntimeException{
     public AccountNotFoundException(String message) {
          super(message);
     }
}
