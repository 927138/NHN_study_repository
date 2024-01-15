<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/28
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>expression</h1>
<%= 10 + 20%><br/>
${10 + 20} <br/><br/><br/>

<h1>action tag</h1>
<jsp:useBean id="member" class="com.example.demo4.bean.Customer" scope="page"/>
<jsp:setProperty name="member" property="id" value="admin"/>
<jsp:setProperty name="member" property="name" value="홍길동"/>

id : <jsp:getProperty name="member" property="id"/> <br/>
name : <jsp:getProperty name="member" property="name"/> <br/><br/>

id : ${member.id} <br/>
name : ${member.name}

</body>
</html>
