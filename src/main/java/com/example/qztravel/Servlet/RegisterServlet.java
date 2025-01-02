package com.example.travelweb.Servlet;

import com.example.travelweb.User;
import com.example.travelweb.DAO.UserDAO;
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
        String confirmPassword = request.getParameter("confirmPassword");

        UserDAO userDAO = new UserDAO();

        if (userDAO.checkUsernameExists(username)) {
            response.getWriter().println("用户名已存在，请重新输入");
            return;
        }

        if (!password.equals(confirmPassword)) {
            response.getWriter().println("两次输入的密码不一致，请重新输入");
            return;
        }

        User user = new User(username, password);
        if (userDAO.registerUser(user)) {
            response.getWriter().println("注册成功");
        } else {
            response.getWriter().println("注册失败，请稍后重试");
        }
    }
}