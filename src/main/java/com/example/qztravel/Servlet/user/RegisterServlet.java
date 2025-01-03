package com.example.qztravel.Servlet.user;

import com.example.qztravel.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        if (userDAO.checkUsernameExists(username)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("用户名已存在，请重新输入");
        } else {
            if (userDAO.registerUser(username,password)) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("注册成功");
            } else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("注册失败，请稍后重试");
            }
        }
    }
}