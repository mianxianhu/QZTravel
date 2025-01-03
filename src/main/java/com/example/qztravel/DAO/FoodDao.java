package com.example.qztravel.DAO;

import com.example.qztravel.Bean.FoodBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDao {

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

    public List<FoodBean> getAllFoods() {
        List<FoodBean> foods = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT  name, description FROM foods");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                FoodBean food = new FoodBean(name,description);
                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }
}