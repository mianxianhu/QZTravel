<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h2>登录</h2>
<form action="Login" method="post">
    <label for="username">账号:</label>
    <input type="text" id="username" name="username"><br><br>
    <label for="password">密码:</label>
    <input type="password" id="password" name="password"><br><br>
    <input type="submit" value="登录">
</form>
<p>没有账号？<a href="register.jsp">注册</a></p>
</body>
</html>