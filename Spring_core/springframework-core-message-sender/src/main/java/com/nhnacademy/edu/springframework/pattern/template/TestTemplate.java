package com.nhnacademy.edu.springframework.pattern.template;

public class TestTemplate {
     public static void main(String[] args) {
          AbstractProcessor processor = new ProcessorImpl();
          processor.process();
     }
}
