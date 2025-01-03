package com.example.qztravel.DAO;
import com.example.qztravel.Bean.ScenicSpotBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ScenicSpotDao {

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


    // 查询所有景区信息
    public List<ScenicSpotBean> getAllScenicSpots() {
        List<ScenicSpotBean> scenicSpots = new ArrayList<>();
        String sql = "SELECT name, description, address, opentime FROM scenic_spots";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ScenicSpotBean scenicSpot = new ScenicSpotBean();
                scenicSpot.setName(rs.getString("name"));
                scenicSpot.setDescription(rs.getString("description"));
                scenicSpot.setAddress(rs.getString("address"));
                scenicSpot.setOpenTime(rs.getString("open_time"));
                scenicSpots.add(scenicSpot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scenicSpots;
    }


    // 添加景区信息
    public void addScenicSpot(ScenicSpotBean scenicSpot) {
        String sql = "INSERT INTO scenic_spots (name, description, address, opentime) VALUES (?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, scenicSpot.getName());
            pstmt.setString(2, scenicSpot.getDescription());
            pstmt.setString(3, scenicSpot.getAddress());
            pstmt.setString(4, scenicSpot.getOpenTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 更新景区信息
    public void updateScenicSpot(ScenicSpotBean scenicSpot) {
        String sql = "UPDATE scenic_spots SET description =?, address =?, opentime =? WHERE name =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, scenicSpot.getDescription());
            pstmt.setString(2, scenicSpot.getAddress());
            pstmt.setString(3, scenicSpot.getOpenTime());
            pstmt.setString(4, scenicSpot.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 删除景区信息
    public void deleteScenicSpot(String name) {
        String sql = "DELETE FROM scenic_spots WHERE name =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}