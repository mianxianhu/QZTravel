package com.example.qztravel.DAO;

import com.example.qztravel.Bean.CommentBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CommentDao {

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


    public List<CommentBean> getAllComments() {
        List<CommentBean> comments = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT id, username, comment, date FROM comments");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String comment = rs.getString("comment");
                String date = rs.getString("date");
                CommentBean commentBean = new CommentBean(id, username, comment, date);
                comments.add(commentBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }


    public void addComment(String username, String comment, String date) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO comments (username, comment, date) VALUES (?,?,?)")) {
            stmt.setString(1, username);
            stmt.setString(2, comment);
            stmt.setString(3, date);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}