package com.example.demo4.sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SContext")
public class SContext extends HttpServlet {

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String contextId = getServletContext().getInitParameter("id");
          String contextPw = getServletContext().getInitParameter("pw");


          System.out.println(contextId + ", " + contextPw);
     }
}
