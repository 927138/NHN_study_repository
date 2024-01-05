package com.nhnacademy.edu.springframework.pattern.factory;

public class CsvDocument extends Document{

     @Override
     public void open(){
          System.out.println("open the csvDocument");
     }
}
