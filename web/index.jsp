<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome</title>
  <link rel="stylesheet" href="CSS/style.css" type="text/css">
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/startServlet">
  <h1>Arena</h1>
  <p>Login:
    <input maxlength="25" size ="40" name="login"></p>
  <p>Password:
    <input type="password" maxlength="25" size="40" name="password"></p>
  <input type="submit" value="login"/>
  <p><a href="registry.jsp">Registry</a></p>
</form>
</body>
</html>