package com.example.qztravel.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.qztravel.Bean.UserBean;


public class UserManagementServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao dao = new UserDao();
        List<UserBean> users = dao.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/userManagement.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        UserDao dao = new UserDao();
        if ("add".equals(action)) {
            UserBean user = new UserBean();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            dao.addUser(user);
        } else if ("update".equals(action)) {
            UserBean user = new UserBean();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            dao.updateUser(user);
        } else if ("delete".equals(action)) {
            String userId = request.getParameter("userId");
            dao.deleteUser(userId);
        }
        doGet(request, response);
    }
}