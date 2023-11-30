package com.example.demo3.servlet;

import com.example.demo3.dto.Student;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "studentListServlet", urlPatterns = "/student/list")
public class StudentListServlet extends HttpServlet {

     private StudentRepository studentRepository;

     @Override
     public void init(ServletConfig config) throws ServletException {
          studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
     }

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //student list 구하기
          List<Student> studentList = studentRepository.getStudents();
          req.setAttribute("studentList",studentList);
//          log.info(studentList.toString());
          // /student/list.jsp <- forward 하기

//          RequestDispatcher rd = req.getRequestDispatcher("/student/list.jsp");
//          rd.forward(req, resp);
          req.setAttribute("view", "/student/list.jsp");

     }

}
