<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/27
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>forward Main page</h1>

<jsp:forward page="forwardSub.jsp">
    <jsp:param name="id" value="admin"/>
    <jsp:param name="pw" value="1234"/>
</jsp:forward>

</body>
</html>
