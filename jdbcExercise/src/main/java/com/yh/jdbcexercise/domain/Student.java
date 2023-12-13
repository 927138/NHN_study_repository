package com.yh.jdbcexercise.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {

     public enum GENDER{
          M, W
     }

     private final String id;
     private final String name;
     private final GENDER gender;
     private final int age;
     private final LocalDateTime createAt;

     public Student(String id, String name, GENDER gender, int age){
          this.id = id;
          this.name = name;
          this.gender = gender;
          this.age = age;
          this.createAt = LocalDateTime.now();
     }

     public Student(String id, String name, GENDER gender, int age, LocalDateTime createAt) {
          this.id = id;
          this.name = name;
          this.gender = gender;
          this.age = age;
          this.createAt = createAt;
     }

     public String getId() {
          return id;
     }

     public String getName() {
          return name;
     }

     public GENDER getGender() {
          return gender;
     }

     public int getAge() {
          return age;
     }

     public LocalDateTime getCreateAt() {
          return createAt;
     }

     @Override
     public String toString() {
          return "Student{" +
                  "id='" + id + '\'' +
                  ", name='" + name + '\'' +
                  ", gender=" + gender +
                  ", age=" + age +
                  ", createAt=" + createAt +
                  '}';
     }
}
