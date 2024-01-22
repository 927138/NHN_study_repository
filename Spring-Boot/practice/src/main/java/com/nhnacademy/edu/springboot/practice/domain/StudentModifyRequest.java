package com.nhnacademy.edu.springboot.practice.domain;

import lombok.Data;

@Data
public class StudentModifyRequest {
     private String name;
     private String email;
     private Integer score;
     private String comment;
}
