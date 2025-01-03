package com.example.qztravel.Servlet.admin;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.qztravel.DAO.TicketOrderDao;
import com.example.qztravel.Bean.TicketOrderBean;


public class TicketOrderManagementServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TicketOrderDao dao = new TicketOrderDao();
        List<TicketOrderBean> ticketOrders = dao.getAllTicketOrders();
        request.setAttribute("ticketOrders", ticketOrders);
        request.getRequestDispatcher("/ticketOrderManagement.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        TicketOrderDao dao = new TicketOrderDao();
        if ("add".equals(action)) {
            TicketOrderBean ticketOrder = new TicketOrderBean();
            ticketOrder.setUserId(request.getParameter("userId"));
            ticketOrder.setScenicSpotId(request.getParameter("scenicSpotId"));
            ticketOrder.setOrderTime(request.getParameter("orderTime"));
            ticketOrder.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            dao.addTicketOrder(ticketOrder);
        } else if ("update".equals(action)) {
            TicketOrderBean ticketOrder = new TicketOrderBean();
            ticketOrder.setUserId(request.getParameter("userId"));
            ticketOrder.setScenicSpotId(request.getParameter("scenicSpotId"));
            ticketOrder.setOrderTime(request.getParameter("orderTime"));
            ticketOrder.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            dao.updateTicketOrder(ticketOrder);
        } else if ("delete".equals(action)) {
            String orderId = request.getParameter("orderId");
            dao.deleteTicketOrder(orderId);
        }
        doGet(request, response);
    }
}