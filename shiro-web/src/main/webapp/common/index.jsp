<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>welcome ${msg}</h1>

<ul>菜单列表:
    <shiro:hasPermission name="menu:list">
        <li><a href="">角色列表</a></li>
    </shiro:hasPermission>

    <%--使用shiro标签, 把权限放在里面, name="admin"
    必须是只有admin用户才能访问--%>
    <li><shiro:hasRole name="admin">
        <a href="${pageContext.request.contextPath}/role.do">角色管理</a>
    </shiro:hasRole></li>


    <li></li>
</ul>

<a href="${pageContext.request.contextPath}/logout.do">退出</a>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/8/28
  Time: 上午 11:14
  To change this template use File | Settings | File Templates.
--%>