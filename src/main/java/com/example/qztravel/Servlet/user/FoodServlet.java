package com.example.qztravel.Servlet.user;

import com.example.qztravel.Bean.FoodBean;
import com.example.qztravel.DAO.FoodDao;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Food")
public class FoodServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FoodDao dao = new FoodDao();
        List<FoodBean> foods = dao.getAllFoods();
        request.setAttribute("foods", foods);
        request.getRequestDispatcher("/food.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}