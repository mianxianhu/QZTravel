<%@ page import="com.example.qztravel.Bean.UserBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<h1>用户管理</h1>
<form action="UserManagement" method="post">
    <input type="hidden" name="action" value="add">
    <label for="AddUsername">用户名:</label>
    <input type="text" id="AddUsername" name="username"><br>
    <label for="AddPassword">密码:</label>
    <input type="password" id="AddPassword" name="password"><br>
    <input type="submit" value="添加用户">
</form>
<table border="1">
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    <%
        List<UserBean> users = (List<UserBean>) request.getAttribute("users");
        if (users!= null) {
            for (UserBean user : users) {
    %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getUsername() %></td>
        <td><%= user.getPassword() %></td>
        <td>
            <form action="UserManagement" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="<%= user.getId() %>">
                <label for="username">用户名:</label>
                <input type="text" id="username" name="username" value="<%= user.getUsername() %>"><br>
                <label for="password">密码:</label>
                <input type="password" id="password" name="password" value="<%= user.getPassword() %>"><br>
                <input type="submit" value="更新">
            </form>
            <form action="UserManagement" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="userId" value="<%= user.getId() %>">
                <input type="submit" value="删除">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>