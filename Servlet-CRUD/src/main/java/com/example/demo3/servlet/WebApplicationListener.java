package com.example.demo3.servlet;

import com.example.demo3.dto.Gender;
import com.example.demo3.dto.Student;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener()
public class WebApplicationListener implements ServletContextListener {

     @Override
     public void contextInitialized(ServletContextEvent sce) {
          ServletContext context = sce.getServletContext();
          StudentRepository repository = new MapStudentRepository();

          for(int i=1; i<=10; i++){
               Student st = new Student();
               st.setId(String.valueOf(i));
               st.setName("student"+i);
               st.setGender(i % 2 == 0 ? Gender.F : Gender.M);
               st.setCreatedAt(LocalDateTime.now());
               st.setAge(ThreadLocalRandom.current().nextInt(20, 30));

               repository.save(st);
          }
          context.setAttribute("studentRepository", repository);
     }
}
