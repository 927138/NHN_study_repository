<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/27
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%! int age;%>

<%
    age = Integer.parseInt(request.getParameter("age"));

    if(age>= 20)
         response.sendRedirect("pass.jsp?age="+age);
    else
         response.sendRedirect("nonPass.jsp?age="+age);
%>


<%=age %>
</body>
</html>
