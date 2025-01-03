// AdminLoginServlet.java
package com.example.qztravel.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 假设管理员用户名和密码，实际中可从数据库中查询
        String adminUsername = "admin";
        String adminPassword = "123";

        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            // 登录成功，将登录信息存储在会话中
            HttpSession session = request.getSession();
            session.setAttribute("admin", username);
            // 转发到管理员管理页面
            request.getRequestDispatcher("/adminManage.jsp").forward(request, response);
        } else {
            // 登录失败，设置错误信息
            request.setAttribute("error", "用户名或密码错误");
            // 转发到登录页面
            request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
        }
    }
}