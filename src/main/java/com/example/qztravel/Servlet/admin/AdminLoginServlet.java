// AdminLoginServlet.java
package com.example.qztravel.Servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 假设管理员用户名和密码，实际中可从数据库中查询
        String adminUsername = "admin";
        String adminPassword = "123456";

        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            response.sendRedirect("Management.jsp");
        } else {
            // 登录失败，设置错误信息
            request.setAttribute("error", "用户名或密码错误");
            // 转发到登录页面
            request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
        }
    }
}