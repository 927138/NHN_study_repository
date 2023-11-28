<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/28
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    Cookie cookie = new Cookie("cookieName", "cookieValue");
    cookie.setMaxAge(60*60);
    response.addCookie(cookie);

%>

<a href="cookieget.jsp">cookieGet</a>

</body>
</html>
