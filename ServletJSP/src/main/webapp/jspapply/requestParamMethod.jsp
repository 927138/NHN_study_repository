<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/27
  Time: 9:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%!
    String name, id, pw;
%>

<%
    request.setCharacterEncoding("UTF-8");

    id = request.getParameter("id");
    name = request.getParameter("name");
    pw = request.getParameter("pw");
%>

id : <%=id%> <br/>
name : <%=name%> <br/>
password : <%=pw%> <br/>

</body>
</html>
