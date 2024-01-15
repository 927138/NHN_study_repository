package com.example.demo4.sevlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;


public class SContextListener implements ServletContextListener {

     @Override
     public void contextInitialized(ServletContextEvent sce) {
          System.out.println("context Initalized");

     }

     @Override
     public void contextDestroyed(ServletContextEvent sce) {
          System.out.println("context Destoryed");
     }
}
