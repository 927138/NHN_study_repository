package com.nhnacademy.edu.springframework.pattern.template;

public class ProcessorImpl extends AbstractProcessor{

     // loggin을 통해 template pattern의 구조 확인.
     @Override
     protected void preProcess(){
          System.out.println("pre condition");
     }

     @Override
     protected void useProcess(){
          System.out.println("use condition");
     }

     @Override
     protected  void postProcess(){
          System.out.println("post condition");
     }
}
