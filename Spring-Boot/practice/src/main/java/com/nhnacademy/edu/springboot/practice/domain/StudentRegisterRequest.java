package com.nhnacademy.edu.springboot.practice.domain;

import lombok.Data;

@Data
public class StudentRegisterRequest {
     private Long id;
     private String name;
     private String email;
     private Integer score;
     private String comment;
}
