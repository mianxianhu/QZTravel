<%@ page import="com.example.qztravel.Bean.ScenicSpotBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>景点管理</title>
</head>
<body>
<h1>景点管理</h1>
<form action="scenicSpotManagement" method="post">
    <input type="hidden" name="action" value="add">
    <label for="name">名称:</label>
    <input type="text" id="name" name="name"><br>
    <label for="description">描述:</label>
    <input type="text" id="description" name="description"><br>
    <label for="address">地址:</label>
    <input type="text" id="address" name="address"><br>
    <label for="openTime">开放时间:</label>
    <input type="text" id="openTime" name="openTime"><br>
    <input type="submit" value="添加景点">
</form>
<table border="1">
    <tr>
        <th>名称</th>
        <th>描述</th>
        <th>地址</th>
        <th>开放时间</th>
        <th>操作</th>
    </tr>
    <%
        List<ScenicSpotBean> scenicSpots = (List<ScenicSpotBean>) request.getAttribute("scenicSpots");
        if (scenicSpots!= null) {
            for (ScenicSpotBean scenicSpot : scenicSpots) {
    %>
    <tr>
        <td><%= scenicSpot.getName() %></td>
        <td><%= scenicSpot.getDescription() %></td>
        <td><%= scenicSpot.getAddress() %></td>
        <td><%= scenicSpot.getOpenTime() %></td>
        <td>
            <form action="scenicSpotManagement" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="name" value="<%= scenicSpot.getName() %>">
                <label for="description">描述:</label>
                <input type="text" id="description" name="description" value="<%= scenicSpot.getDescription() %>"><br>
                <label for="address">地址:</label>
                <input type="text" id="address" name="address" value="<%= scenicSpot.getAddress() %></br>
                    <label for="openTime">开放时间:</label>
                <input type="text" id="openTime" name="openTime" value="<%= scenicSpot.getOpenTime() %>"><br>
                <input type="submit" value="更新">
            </form>
            <form action="scenicSpotManagement" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="name" value="<%= scenicSpot.getName() %>">
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