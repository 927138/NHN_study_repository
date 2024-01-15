<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/28
  Time: 9:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  Cookie[] cookie = request.getCookies();

  for(int i=0; i<cookie.length; i++){
    if(cookie[i].getName().equals("id")){
      System.out.println("dfdf");
      cookie[i].setMaxAge(0);
      response.addCookie(cookie[i]);
    }
  }

  response.sendRedirect("login.jsp");
%>

</body>
</html>
