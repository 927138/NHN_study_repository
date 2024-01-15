package com.example.demo3.servlet;

import com.example.demo3.dto.Student;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@WebServlet(name="studentViewServlet", urlPatterns="/student/view")
public class StudentViewServlet extends HttpServlet {

     private StudentRepository repository;

     @Override
     public void init(ServletConfig config) throws ServletException {
          this.repository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
     }

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String id = req.getParameter("id");

          log.info("Student View 1" + id);
          Student st = repository.getStudentById(id);
          req.setAttribute("studentObject", st);

          log.info("Student View 2" + id);

//          RequestDispatcher rd = req.getRequestDispatcher("/student/view.jsp");
//          rd.forward(req, resp);
          req.setAttribute("view", "/student/view.jsp");
     }

}
