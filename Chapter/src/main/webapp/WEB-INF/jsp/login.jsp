<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: heyao
  Date: 2017/3/8
  Time: 下午12:02
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>晓会的专属秘密空间</title>
</head>
<body>
<c:if test="${!empty error}">
    <font color="red"><c:out value="${error}"/></font>
</c:if>
<form action="<c:url value="/loginCheck.html"/>" method="post">
    用户名：
    <input type="text" name="userName"/>
    <br/>
    密 码：
    <input type="password" name="password"/>
    <br/>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>
