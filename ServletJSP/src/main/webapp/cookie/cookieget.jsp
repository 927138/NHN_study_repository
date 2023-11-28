<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/28
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  Cookie[] cookies = request.getCookies();

  for(int i=0; i<cookies.length; i++){
    String str = cookies[i].getName();

//    if(str.equals("cookieName")){
      out.println("cookie["+ i + "] Name  :  " + cookies[i].getName() + "<br/>");
      out.println("cookie["+ i + "] Value  :  " + cookies[i].getValue() + "<br/>");
//    }
  }
%>

  <a href="cookiedel.jsp">cookie delete</a>

</body>
</html>
