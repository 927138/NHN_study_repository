package com.nhnacademy.edu.springboot.practice.interceptor;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
     @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
             throws Exception {

          String loginResult = (String) request.getSession().getAttribute("checkedLogin");
          if(Objects.isNull(loginResult) ||  !loginResult.equals("true")){
               response.sendRedirect("/login");
               return false;
          }
          return true;
     }
}