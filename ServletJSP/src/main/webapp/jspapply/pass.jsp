<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/27
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%! int age; %>

<%
  age = Integer.parseInt(request.getParameter("age"));
%>

age<br/>
성인인증 성공

<a href="formResponse.jsp"> 처음으로 이동</a>
</body>
</html>
