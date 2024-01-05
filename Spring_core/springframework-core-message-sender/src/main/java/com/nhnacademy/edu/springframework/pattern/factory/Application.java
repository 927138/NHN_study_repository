package com.nhnacademy.edu.springframework.pattern.factory;

public abstract class Application {
     public void openDocument(){
          Document docu = createDocument();
          docu.open();
     }

     protected abstract Document createDocument();
}
