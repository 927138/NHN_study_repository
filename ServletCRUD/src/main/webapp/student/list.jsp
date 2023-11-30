<%@ page import="com.example.demo3.dto.Student" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.demo3.servlet.StudentRepository" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/27
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>student - list</title>
  <link rel="stylesheet" href="https://unpkg.com/mvp.css" />
</head>

<body>
<h1>학생 리스트</h1>
<p><a href="/student/register.do" >학생(등록)</a></p>
<table>
  <thead>
  <tr>
    <th>아이디</th>
    <th>이름</th>
    <th>성별</th>
    <th>나이</th>
    <th>cmd</th>
  </tr>
  </thead>
  <tbody>
  <!--todo list 구현하기 c:foreach -->

  <c:forEach var="student" items="${ studentList }">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.gender}</td>
      <td>${student.age}</td>
      <td>
        <c:url var="view" value="/student/view.do" scope="request">
          <c:param name="id" value="${student.id}"/>
        </c:url>
        <a href="${view}"> 조회</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>