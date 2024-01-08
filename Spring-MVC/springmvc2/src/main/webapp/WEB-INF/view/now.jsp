<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<%= request.getAttribute("time")%> <br/>
<%= request.getAttribute("name")%><br/>
<%= request.getAttribute("userId")%>

<%= new Date().toString() %>