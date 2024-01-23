package com.nhnacademy.edu.springboot.practice.student.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Student {
     private final String name;
     private final Integer score;
}
