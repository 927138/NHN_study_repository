package com.example.demo3;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@WebServlet(name = "frontServlet", urlPatterns="*.do")
public class FrontServlet extends HttpServlet {

     private static final String REDIRECT_PREFIX="redirect";

     @Override
     public void service(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

          response.setContentType("text/html");
          response.setCharacterEncoding("UTF-8");

          try{
               //실제 요청 처리할 servlet을 결정
               String servletPath = resolveServlet(request.getServletPath());
               log.info("FrontServlet requestPath : " + servletPath);
               RequestDispatcher rd = request.getRequestDispatcher(servletPath);
               rd.include(request, response);

               //실제 요청을 처리한 servlet이 'view'라는 request 속성값으로 view를 전달해 줌.
               String view = (String) request.getAttribute("view");
               log.info("FrontServlet View : " + view);
               if (view.startsWith(REDIRECT_PREFIX)) {
                    log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length()+1));
                    // todo  `redirect:`로 시작하면 redirect 처리.
                    response.sendRedirect(view.substring(REDIRECT_PREFIX.length() + 1));

               } else {
                    //todo redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include시킴.
                    rd = request.getRequestDispatcher(view);
                    rd.include(request, response);

               }
          }catch(Exception ex){
               log.error("front servlet error");
               //todo 공통 error 처리 - ErrorServlet 참고해서 처리


               //todo  forward - /error.jsp

          }


     }

     private String resolveServlet(String servletPath){
          String path = null;

          if("/student/list.do".equals(servletPath)){
               path = "/student/list";
          }else if("/student/view.do".equals(servletPath)){
               path = "/student/view";
          }else if("/student/delete.do".equals(servletPath)){
               path = "/student/delete";
          }else if("/student/update.do".equals(servletPath)){
               path = "/student/update";
          }else if("/student/register.do".equals(servletPath)){
               path = "/student/register";
          }else if("/error.do".equals(servletPath)){
               path = "/error";
          }
          return path;
     }
}
