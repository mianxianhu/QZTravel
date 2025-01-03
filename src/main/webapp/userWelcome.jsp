<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 26385
  Date: 2025/1/3
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
  <h1>欢迎您</h1>
  <a href="<c:url value="/ScenicSpot"/>">景区介绍</a>
  <a href="<c:url value="/Food"/>">美食介绍</a>
  <a href="<c:url value="/Comment"/>">评论专区</a>
</body>
</html>
