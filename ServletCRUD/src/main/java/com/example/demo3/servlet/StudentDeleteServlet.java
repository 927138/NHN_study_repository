package com.example.demo3.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet {
     private StudentRepository repository;

     @Override
     public void init(ServletConfig config) throws ServletException {
          this.repository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
     }

     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String id = req.getParameter("id");

          repository.deleteById(id);

          req.setAttribute("view", "redirect:/student/list.do");
     }
}
