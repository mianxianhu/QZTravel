<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>评论专区</title>
</head>
<body>
<h1>泉州旅游评论专区</h1>
<form action="Comment" method="post">
  <label for="username">用户名:</label>
  <input type="text" id="username" name="username" placeholder="请使用英文名"><br>
  <label for="comment">评论:</label>
  <input type="text" id="comment" name="comment" placeholder="请使用英文评论"><br>
  <label for="date">日期:</label>
  <input type="text" id="date" name="date"><br>
  <input type="submit" value="提交评论">
</form>
<h2>用户评论</h2>
<table border="1">
  <tr>
    <th>用户名</th>
    <th>评论</th>
    <th>日期</th>
  </tr>
  <c:forEach items="${comments}" var="comment">
    <tr>
      <td>${comment.username}</td>
      <td>${comment.comment}</td>
      <td>${comment.date}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>