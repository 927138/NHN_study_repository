package com.example.demo3.servlet;

import com.example.demo3.dto.Gender;
import com.example.demo3.dto.Student;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name="studentRegisterServlet", urlPatterns="/student/register")
public class StudentRegisterServlet extends HttpServlet {

     private StudentRepository repository;

     @Override
     public void init(ServletConfig config) throws ServletException {
          this.repository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
     }

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //todo  /student/register.jsp forward 합니다.
//          RequestDispatcher rd = req.getRequestDispatcher("/student/register.jsp");
//          rd.forward(req, resp);

          req.setAttribute("view", "/student/register.jsp");

     }

     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

          String id = req.getParameter("id");
          String name = req.getParameter("name");

          Gender gender = null;
          if(Objects.nonNull(req.getParameter("gender")))
               gender = Gender.valueOf(req.getParameter("gender"));

          Integer age = null;
          if(Objects.nonNull(req.getParameter("age")))
               age = Integer.parseInt(req.getParameter("age"));

          if(Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age))
               throw new RuntimeException("id name gender age 확인");

          //todo save 구현
          Student st = new Student(id, name, gender, age);
          repository.save(st);

          //todo redirect /student/view?id=student1
//          resp.sendRedirect("/student/view?id="+id);
          req.setAttribute("view", "redirect:/student/view?id="+st.getId());
     }
}
