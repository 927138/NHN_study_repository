package com.nhnacademy.edu.springframework.pattern.template;

public abstract class AbstractProcessor {
     public final void process(){
          preProcess();
          useProcess();
          postProcess();
     }

     protected abstract void preProcess();
     protected abstract void useProcess();
     protected abstract void postProcess();
}
