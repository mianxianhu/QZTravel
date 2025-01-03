package com.example.qztravel.Servlet.user;
import com.example.qztravel.DAO.ScenicSpotDao;
import com.example.qztravel.Bean.ScenicSpotBean;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ScenicSpotServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ScenicSpotDao dao = new ScenicSpotDao();
        List<ScenicSpotBean> scenicSpots = dao.getAllScenicSpots();

        // 将景区信息列表存储在请求中
        request.setAttribute("scenicSpots", scenicSpots);

        // 转发到 JSP 页面
        request.getRequestDispatcher("/scenicSpot.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            ScenicSpotBean scenicSpot = new ScenicSpotBean();
            scenicSpot.setName(request.getParameter("name"));
            scenicSpot.setDescription(request.getParameter("description"));
            scenicSpot.setAddress(request.getParameter("address"));
            scenicSpot.setOpenTime(request.getParameter("openTime"));
            ScenicSpotDao dao = new ScenicSpotDao();
            dao.addScenicSpot(scenicSpot);
        } else if ("update".equals(action)) {
            ScenicSpotBean scenicSpot = new ScenicSpotBean();
            scenicSpot.setName(request.getParameter("name"));
            scenicSpot.setDescription(request.getParameter("description"));
            scenicSpot.setAddress(request.getParameter("address"));
            scenicSpot.setOpenTime(request.getParameter("openTime"));
            ScenicSpotDao dao = new ScenicSpotDao();
            dao.updateScenicSpot(scenicSpot);
        } else if ("delete".equals(action)) {
            String name = request.getParameter("name");
            ScenicSpotDao dao = new ScenicSpotDao();
            dao.deleteScenicSpot(name);
        }
        doGet(request, response);
    }
}