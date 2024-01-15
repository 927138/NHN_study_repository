<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/28
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%!
  String id, pw;
%>

<%
  id = request.getParameter("id");
  pw = request.getParameter("pw");

  if(id.equals("admin") && pw.equals("1234")){
    Cookie cookie = new Cookie("id", id);

    cookie.setMaxAge(300);
    response.addCookie(cookie);
    response.sendRedirect("welcome.jsp");
  }else{
    response.sendRedirect("login.jsp");
  }
%>

</body>

</html>
