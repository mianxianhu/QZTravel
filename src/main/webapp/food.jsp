<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>美食介绍</title>
</head>
<body>
<h1>美食介绍</h1>
<table border="1">
    <tr>
        <th>名称</th>
        <th>描述</th>
    </tr>
    <c:forEach items="${foods}" var="food">
        <tr>
            <td>${food.name}</td>
            <td>${food.description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>