package com.nhnacademy.springmvc.interceptor;

import com.nhnacademy.springmvc.contoller.LoginController;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckingInterceptor implements HandlerInterceptor {
     @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
             throws Exception {

          HttpSession httpSession = request.getSession(false);
          if(Objects.isNull(httpSession) ||
                  Objects.isNull(httpSession.getAttribute(LoginController.LOGIN_SUCESSES))){
               response.sendRedirect("/");
               return false;
          }
          return true;
     }
}
