package com.example.qztravel.Servlet.admin;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.qztravel.DAO.UserDAO;
import com.example.qztravel.Bean.UserBean;

@WebServlet("/UserManagement")
public class UserManagementServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        List<UserBean> users = dao.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/userManagement.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        UserDAO dao = new UserDAO();
        if ("add".equals(action)) {
            UserBean user = new UserBean();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            dao.addUser(user);
        } else if ("update".equals(action)) {
            UserBean user = new UserBean();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            dao.updateUser(user);
        } else if ("delete".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
        }
        doGet(request, response);
    }
}