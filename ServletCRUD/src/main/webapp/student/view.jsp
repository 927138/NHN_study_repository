<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/28
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>학생-조회</title>
    <link rel="stylesheet" href="/style.css" />
</head>
<body>
<table>
    <tbody>
    <!-- todo view 구현 -->
        <tr>
            <td>id</td>
            <td>${studentObject.id}</td>
        </tr>
    <tr>
        <td>name</td>
        <td>${studentObject.name}</td>
    </tr>
    <tr>
        <td>gender</td>
        <td>${studentObject.gender}</td>
    </tr>
    <tr>
        <td>age</td>
        <td>${studentObject.age}</td>
    </tr>
    </tbody>
</table>
<ul>
    <li><a href="/student/list">리스트</a></li>
    <li>
        <c:url var="update_link" value="/student/update.do">
            <c:param name="id" value="${studentObject.id}"/>
        </c:url>
        <a href="${update_link}">수정</a>
    </li>
    <li>
        <form method="post" action="/student/delete.do">
            <input type="hidden" name="id" value="${studentObject.id}">
            <button type="submit">delete</button>
        </form>
     </li>

 </ul>

</body>
</html>
