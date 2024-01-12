package com.nhnacademy.springmvc.domain;


import lombok.Getter;


@Getter
public class Customer {

     private final String id;
     String password;
     private String name;

     public static Customer createUser(String id){
          return new Customer(id);
     }

     private Customer(String id){
          this.id = id;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public void setName(String name) {
          this.name = name;
     }
}
