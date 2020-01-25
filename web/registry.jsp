<%--
  Created by IntelliJ IDEA.
  User: danil
  Date: 24.01.2020
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registry</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/registry">
    <h1>Registry</h1>
    <p>Enter login:
        <input maxlength="25" size ="40" name="login"></p>
    <p>Enter password:
        <input type="password" maxlength="25" size="40" name="password"></p>
    <input type="submit" name="add" value="OK">
    <p><a href="index.jsp">Return</a></p>
</form>
</body>
</html>
