<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/27
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    int i = 0;
    while(true){
         i++;
         out.println("2 * " + i + " = " + (2*i) + "<br/>");

         if(i >= 9) break;
    }
%>


</body>
</html>
