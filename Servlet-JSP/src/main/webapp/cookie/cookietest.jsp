<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/28
  Time: 9:32 PM
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

  if(cookies != null){
    for(int i=0; i<cookies.length; i++){
      out.println(cookies[i].getName() + "<br/>");
      out.println(cookies[i].getValue() + "<br/>");
    }
  }
%>

</body>
</html>
