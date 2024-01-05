package com.nhnacademy.edu.springframework.pattern.factory;

public class TestFactory {

     public static void main(String[] args) {
          Application app = new CsvApplication();
          app.openDocument();
     }

}

