<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023/11/29
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:set var="varName" value="admin"/>
varName : <c:out value="${varName}"/><br/>

<c:remove var="varName"/>
varName : <c:out value="${varName}"/> <br/><hr/>

<c:catch var="error">
    <%=2/0%>
</c:catch>
<c:out value="${error}"/> <br/><hr/>

<%! int i = 20; %>
<c:choose>
    <c:when test="${i >= 20}"> <c:out value="성인"/> </c:when>
    <c:otherwise> <c:out value="청소년"/> </c:otherwise>
</c:choose><hr/>

<c:forEach var="foreach" begin="1" end="30" step="1">
    ${foreach}
</c:forEach>
</body>
</html>
