// TicketOrderDao.java
package com.example.qztravel.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.qztravel.Bean.TicketOrderBean;


public class TicketOrderDao {
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Travel";
    private static final String JDBC_USER = "QZTW";
    private static final String JDBC_PASSWORD = "123";


    // 获取数据库连接
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }


    // 获取所有门票订单信息
    public List<TicketOrderBean> getAllTicketOrders() {
        List<TicketOrderBean> ticketOrders = new ArrayList<>();
        String sql = "SELECT order_id, user_id, scenic_spot_id, order_time, quantity FROM ticket_orders";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                TicketOrderBean ticketOrder = new TicketOrderBean();
                ticketOrder.setOrderId(rs.getInt("order_id"));
                ticketOrder.setUserId(rs.getString("user_id"));
                ticketOrder.setScenicSpotId(rs.getString("scenic_spot_id"));
                ticketOrder.setOrderTime(rs.getString("order_time"));
                ticketOrder.setQuantity(rs.getInt("quantity"));
                ticketOrders.add(ticketOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketOrders;
    }


    // 添加门票订单
    public void addTicketOrder(TicketOrderBean ticketOrder) {
        String sql = "INSERT INTO ticket_orders (order_id, user_id, scenic_spot_id, order_time) VALUES (?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ticketOrder.getOrderId());
            stmt.setString(2, ticketOrder.getUserId());
            stmt.setString(3, ticketOrder.getScenicSpotId());
            stmt.setString(4, ticketOrder.getOrderTime());
            int rowsInserted = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 更新门票订单
    public void updateTicketOrder(TicketOrderBean ticketOrder) {
        String sql = "UPDATE ticket_orders SET user_id =?, scenic_spot_id =?, order_time =?, quantity =? WHERE order_id =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ticketOrder.getUserId());
            pstmt.setString(2, ticketOrder.getScenicSpotId());
            pstmt.setString(3, ticketOrder.getOrderTime());
            pstmt.setInt(4, ticketOrder.getQuantity());
            pstmt.setInt(5, ticketOrder.getOrderId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 删除门票订单
    public void deleteTicketOrder(String orderId) {
        String sql = "DELETE FROM ticket_orders WHERE order_id =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(orderId));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}