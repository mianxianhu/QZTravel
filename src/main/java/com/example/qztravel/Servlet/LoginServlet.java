package com.example.travelweb.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载失败: " + e.getMessage());
            return;
        }
        // 获取用户输入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 这里可以添加用户认证逻辑，比如和数据库中的用户信息进行比较
        // 为了简单起见，这里仅做简单的用户名和密码验证
        if ("admin".equals(username) && "123456".equals(password)) {
            // 登录成功，重定向到欢迎页面
            response.getWriter().println("登录成功");
        } else {
            // 登录失败，重定向到登录页面，并添加错误信息
            response.getWriter().println("登录失败，请检查用户名和密码");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}