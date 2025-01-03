<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="register" method="post">
    <label for="username">用户名:</label>
    <input type="text" id="username" name="username" required><br><br>
    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required><br><br>
    <label for="confirmPassword">确认密码:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required><br><br>
    <input type="submit" value="注册">
</form>
<p>已有账号？<a href="login.jsp">登录</a></p>
</body>
</html>