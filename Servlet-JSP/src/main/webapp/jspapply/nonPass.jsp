<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/27
  Time: 10:00 PM
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

성인컨텐츠 이용 불가

<a href="formResponse.jsp"> 처음으로 이동</a>

</body>
</html>
