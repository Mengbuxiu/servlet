<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/3
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"  language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>success!</h1>
    <%--<c:if test="${not empty name}">--%>
    <input value="<% Object name = request.getAttribute("name");
        System.out.println(name);
    %>">
<%--
    </c:if>
--%>
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
</body>
</html>
