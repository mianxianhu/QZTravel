package com.example.qztravel.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.qztravel.DAO.ScenicSpotDao;
import com.example.qztravel.Bean.ScenicSpotBean;

@WebServlet("/ScenicSpotManagement")
public class ScenicSpotManagementServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ScenicSpotDao dao = new ScenicSpotDao();
        List<ScenicSpotBean> scenicSpots = dao.getAllScenicSpots();
        request.setAttribute("scenicSpots", scenicSpots);
        request.getRequestDispatcher("/scenicSpotManagement.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ScenicSpotDao dao = new ScenicSpotDao();
        if ("add".equals(action)) {
            ScenicSpotBean scenicSpot = new ScenicSpotBean();
            scenicSpot.setName(request.getParameter("name"));
            scenicSpot.setDescription(request.getParameter("description"));
            scenicSpot.setAddress(request.getParameter("address"));
            scenicSpot.setOpenTime(request.getParameter("openTime"));
            dao.addScenicSpot(scenicSpot);
        } else if ("update".equals(action)) {
            ScenicSpotBean scenicSpot = new ScenicSpotBean();
            scenicSpot.setName(request.getParameter("name"));
            scenicSpot.setDescription(request.getParameter("description"));
            scenicSpot.setAddress(request.getParameter("address"));
            scenicSpot.setOpenTime(request.getParameter("openTime"));
            dao.updateScenicSpot(scenicSpot);
        } else if ("delete".equals(action)) {
            String name = request.getParameter("name");
            dao.deleteScenicSpot(name);
        }
        doGet(request, response);
    }
}