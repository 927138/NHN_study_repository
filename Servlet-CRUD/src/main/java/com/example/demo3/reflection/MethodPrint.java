package com.example.demo3.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodPrint {

     public static void main(String[] args) {

          Class c = ArrayList.class;
          Method[] method = c.getDeclaredMethods();

          for(int i=0; i< method.length; i++){
               System.out.println(method[i]);
          }

     }

}
