package com.example.demo3.reflection;

public class Person {
     public String name;
     private int age;

     public static int height = 180;

     public Person(){}

     public Person(String name, int age){
          this.name = name;
          this.age = age;
     }

     public void getField(){
          System.out.println("name : " + name + ", " + age);
     }

     public int sum(int left, int right){
          return left + right;
     }

     public static int staticSum(int left, int right){
          return left + right;
     }

     private int privateSum(int left, int right){
          return left + right;
     }
}
