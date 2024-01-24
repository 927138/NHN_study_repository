package com.nhnacademy.edu.springboot.practice.account.exception;

public class AccountAlreadyExistsException extends RuntimeException{
     public AccountAlreadyExistsException(String message) {
          super(message);
     }
}
