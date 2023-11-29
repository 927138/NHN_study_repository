<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/29
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>action tag example</h1>
<jsp:useBean id="cus" class="com.example.demo4.bean.Customer" scope="page"/>
<jsp:setProperty name="cus" property="id" value="admin"/>
<jsp:setProperty name="cus" property="name" value="홍길동"/>

customer Object id : <jsp:getProperty name="cus" property="id"/><br>
customer Object name : <jsp:getProperty name="cus" property="name"/><br><hr/>

</body>
</html>
