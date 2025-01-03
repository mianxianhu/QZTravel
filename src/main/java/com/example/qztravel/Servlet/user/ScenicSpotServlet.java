package com.example.qztravel.Servlet.user;
import com.example.qztravel.DAO.ScenicSpotDao;
import com.example.qztravel.Bean.ScenicSpotBean;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ScenicSpot")
public class ScenicSpotServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ScenicSpotServlet.class.getName());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ScenicSpotDao dao = new ScenicSpotDao();
        List<ScenicSpotBean> scenicSpots = dao.getAllScenicSpots();
        logger.log(Level.INFO,"ScenicSpots size before setting attribute: " + (scenicSpots == null? 0 : scenicSpots.size()));
        request.setAttribute("scenicSpots", scenicSpots);
        request.getRequestDispatcher("/scenicSpot.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }
}