<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/27
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  out.println("server name: " + request.getServerName() + "<br/>");
  out.println("port number: " + request.getServerPort()+ "<br/>");
  out.println("request method : " + request.getMethod()+ "<br/>");
  out.println("request protocol : " + request.getProtocol()+ "<br/>");
  out.println("request URL: " + request.getRequestURL()+ "<br/>");
  out.println("request URI: " + request.getRequestURI()+ "<br/>");

%>

</body>
</html>
