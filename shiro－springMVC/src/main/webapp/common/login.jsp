<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/8/28
  Time: 上午 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login.do" style="text-align: center" method="post">
    <h1>${msg} </h1>
    <input type="text" name="username" placeholder="username"><br>
    <input type="text" name="password" placeholder="password"><br>
    <input type="submit" value="submit">
</form>

</body>
</html>
