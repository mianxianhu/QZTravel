<jsp:useBean id="scenicSpot" scope="request" type="com.example.qztravel.Bean.ScenicSpotBean"/>
<!-- scenicSpot.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>景区介绍</title>
</head>
<body>
<h1>景区介绍</h1>
<div>
  <h2>${scenicSpot.getName()}</h2>
  <p>${scenicSpot.getDescription()}</p>
  <p>地址：${scenicSpot.getAddress()}</p>
  <p>开放时间：${scenicSpot.getOpenTime()}</p>
</div>
</body>
</html>