package com.example.qztravel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        // 数据库连接信息
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Travel";
        String user = "QZTW";
        String password = "123";

        // SQL 语句：创建表
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(20) NOT NULL," +
                "password VARCHAR(20) NOT NULL)";

        try {
            // 1. 加载数据库驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载失败: " + e.getMessage());
            return;
        }

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            // 2. 执行创建表的 SQL 语句
            statement.executeUpdate(createTableSQL);
            System.out.println("表创建成功");
        } catch (SQLException e) {
            System.out.println("表创建失败: " + e.getMessage());
        }
    }
}