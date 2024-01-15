package com.example.demo3.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

//     private String encoding;
//
//     @Override
//     public void init(FilterConfig filterConfig) throws ServletException {
//          this.encoding = filterConfig.getInitParameter("encoding");
//     }

     @Override
     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
             throws IOException, ServletException {
          servletRequest.setCharacterEncoding("UTF-8");
          filterChain.doFilter(servletRequest, servletResponse);
     }
}