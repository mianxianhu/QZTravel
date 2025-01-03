<%@ page import="com.example.qztravel.Bean.TicketOrderBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>门票订单管理</title>
</head>
<body>
<h1>门票订单管理</h1>
<form action="ticketOrderManagement" method="post">
  <input type="hidden" name="action" value="add">
  <label for="userId">用户ID:</label>
  <input type="text" id="userId" name="userId"><br>
  <label for="scenicSpotId">景点ID:</label>
  <input type="text" id="scenicSpotId" name="scenicSpotId"><br>
  <label for="orderTime">订单时间:</label>
  <input type="text" id="orderTime" name="orderTime"><br>
  <label for="quantity">数量:</label>
  <input type="text" id="quantity" name="quantity"><br>
  <input type="submit" value="添加订单">
</form>
<table border="1">
  <tr>
    <th>用户ID</th>
    <th>景点ID</th>
    <th>订单时间</th>
    <th>数量</th>
    <th>操作</th>
  </tr>
  <%
    List<TicketOrderBean> ticketOrders = (List<TicketOrderBean>) request.getAttribute("ticketOrders");
    if (ticketOrders!= null) {
      for (TicketOrderBean ticketOrder : ticketOrders) {
  %>
  <tr>
    <td><%= ticketOrder.getUserId() %></td>
    <td><%= ticketOrder.getScenicSpotId() %></td>
    <td><%= ticketOrder.getOrderTime() %></td>
    <td><%= ticketOrder.getQuantity() %></td>
    <td>
      <form action="ticketOrderManagement" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="orderId" value="<%= ticketOrder.getOrderId() %>">
        <label for="userId">用户ID:</label>
        <input type="text" id="userId" name="userId" value="<%= ticketOrder.getUserId() %>"><br>
        <label for="scenicSpotId">景点ID:</label>
        <input type="text" id="scenicSpotId" name="scenicSpotId" value="<%= ticketOrder.getScenicSpotId() %>"><br>
        <label for="orderTime">订单时间:</label>
        <input type="text" id="orderTime" name="orderTime" value="<%= ticketOrder.getOrderTime() %>"><br>
        <label for="quantity">数量:</label>
        <input type="text" id="quantity" name="quantity" value="<%= ticketOrder.getQuantity() %>"><br>
        <input type="submit" value="更新">
      </form>
      <form action="ticketOrderManagement" method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="orderId" value="<%= ticketOrder.getOrderId() %>">
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