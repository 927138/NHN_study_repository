package com.nhnacademy.edu.springboot.practice.account.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
@Service
@Setter
@EqualsAndHashCode
@Entity
public class Account {
     @Id
     private Long id;
     private String name;
     private String number;
     private Integer balance;

     public Account() {
     }
}
