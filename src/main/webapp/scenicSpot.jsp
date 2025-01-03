<%@ page import="com.example.qztravel.Bean.ScenicSpotBean" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>景区介绍</title>
</head>
<body>
<h1>景区介绍</h1>
<table border="1" >
  <tr>
    <th>名称</th>
    <th>描述</th>
    <th>地址</th>
    <th>开放时间</th>
  </tr>
  <%
    // 从请求中获取景区信息列表
    List<ScenicSpotBean> scenicSpots = (List<ScenicSpotBean>) request.getAttribute("scenicSpots");
    if (scenicSpots!= null) {
      for (ScenicSpotBean scenicSpot : scenicSpots) {
  %>
  <tr >
    <td><%= scenicSpot.getName() %></td>
    <td><%= scenicSpot.getDescription() %></td>
    <td><%= scenicSpot.getAddress() %></td>
    <td><%= scenicSpot.getOpenTime() %></td>
  </tr>
  <%
      }
    }
  %>
</table>
</body>
</html>