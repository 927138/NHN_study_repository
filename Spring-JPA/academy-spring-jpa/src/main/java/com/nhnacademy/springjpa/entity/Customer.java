package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Customers")
public class Customer {
     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
     @Column(name = "cus_id")
     private Long customerId;

     @Column(name = "name")
     private String customerName;

     @Column(name = "email_address")
     private String customerEmailAddress;

     @Column(name = "password")
     private String customerPassword;


}
