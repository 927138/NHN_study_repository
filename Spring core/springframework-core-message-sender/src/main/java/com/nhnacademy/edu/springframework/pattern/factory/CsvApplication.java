package com.nhnacademy.edu.springframework.pattern.factory;

public class CsvApplication extends Application{
     @Override
     protected Document createDocument(){
          return new CsvDocument();
     }
}
