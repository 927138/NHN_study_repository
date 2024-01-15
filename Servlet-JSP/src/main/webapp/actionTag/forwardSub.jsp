<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/27
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>forward sub page</h1><br/>

<%!
    String id, pw;
%>

<%
    id = request.getParameter("id");
    pw = request.getParameter("pw");
%>

jsp:param를 사용하여 request에서 parameter로 값들을 받을 수 잇음.<br/>
현재는 forward tag 에서 사용한 예제 이지만 include tag 에서도 사용이 가능하다.<br/><br/><br/>


id : <%=id%><br/>
pw : <%=pw%> <br/>

주소창을 유심히 볼것
</body>
</html>
