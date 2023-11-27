package com.example.demo4.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SConfig extends HttpServlet {

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

          String name = getInitParameter("id");
          String pw = getInitParameter("pw");

          PrintWriter out = resp.getWriter();

          out.println(name);
          out.print(pw);

     }
}
