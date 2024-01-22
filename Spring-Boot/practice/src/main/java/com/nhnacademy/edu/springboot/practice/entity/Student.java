package com.nhnacademy.edu.springboot.practice.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tables")
public class Student {
     @Id
     private Long id;

     private String name;
     private String email;
     private Integer score;
     private String comment;

     public Student(String name, String email, Integer score, String comment) {
          this.name = name;
          this.email = email;
          this.score = score;
          this.comment = comment;
     }
}
