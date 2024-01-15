<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/28
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="loginOk.jsp" method="post">
  id : <input type="text" name="id"/> <br/>
  pw :  <input type="password" name="pw"/> <br/>
  <input type="submit" value="login"/>
</form>


<%
    Cookie[] cookies = request.getCookies();

    for(int i=0; i<cookies.length; i++){
         out.println(i + "cookies// Name : " + cookies[i].getName() + ", Value : " + cookies[i].getValue() + "<br/>");
    }
%>
</body>
</html>
