package com.nhnacademy.edu.springboot.practice.account.controller;

import com.nhnacademy.edu.springboot.practice.account.domain.ErrorResponse;
import com.nhnacademy.edu.springboot.practice.account.exception.AccountAlreadyExistsException;
import com.nhnacademy.edu.springboot.practice.account.exception.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorResponseController {
     @ExceptionHandler(value = {AccountAlreadyExistsException.class})
     @ResponseStatus(HttpStatus.CONFLICT)
     public ErrorResponse handleConflictException(AccountAlreadyExistsException exception){
          return new ErrorResponse(exception.getMessage());
     }

     @ExceptionHandler(value = {AccountNotFoundException.class})
     @ResponseStatus(HttpStatus.NOT_FOUND)
     public ErrorResponse handleNotFoundException(AccountNotFoundException exception){
          return new ErrorResponse(exception.getMessage());
     }
}
