package com.yh.jdbcexercise.transaction.domain;

public class Account {

     private long number;
     private String name;
     private long balance;

     public Account(long number, String name, long balance) {
          this.number = number;
          this.name = name;
          this.balance = balance;
     }

     public long getAccountNumber() {
          return number;
     }

     public void setAccountNumber(long number) {
          this.number = number;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public long getBalance() {
          return balance;
     }

     public void setBalance(long balance) {
          this.balance = balance;
     }

     public boolean isWithdraw(long value){
          return balance >= value;
     }
}
