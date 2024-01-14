package com.nhnacademy.springmvc.domain;


import lombok.Getter;


@Getter
public class Customer {

     private final String id;
     private String password;
     private String name;
     private Role role;


     public static Customer createUser(String id){
          return new Customer(id);
     }

     private Customer(String id){
          this.id = id;
          this.role = Role.USER;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public void setName(String name) {
          this.name = name;
     }

     public void setRole(Role role) {
          this.role = role;
     }
}
