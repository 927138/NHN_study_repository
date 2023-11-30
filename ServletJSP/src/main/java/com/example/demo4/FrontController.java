package com.example.demo4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@WebServlet("*.do")
public class FrontController extends HttpServlet {

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          log.info("frontController doGet Method executing");
          log.info("Request URL : " + req.getRequestURI());

          resp.sendRedirect("pattern.jsp");
     }
}
