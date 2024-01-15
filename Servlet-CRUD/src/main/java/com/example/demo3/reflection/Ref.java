package com.example.demo3.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Ref {

     public static void main(String[] args){

     }

     public static void newInstance()
             throws Exception {
          Class<Person> c = (Class<Person>) Class.forName(Person.class.getName());
          Constructor<Person> constructor = c.getConstructor(String.class, int.class);

          Person person1 = constructor.newInstance("admin", 1234);
          person1.getField();
     }

     public static void useMethod() throws Exception{
          Class c = Class.forName(Person.class.getName());

          Method pMethod = c.getMethod("sum", int.class, int.class);
          int result = (int) pMethod.invoke(new Person(), 1 , 2);
          System.out.println(result);

          Method sMethod = c.getMethod("staticSum", int.class, int.class);
          result = (int) sMethod.invoke(null, 10, 15);
          System.out.println(result);


     }

}
