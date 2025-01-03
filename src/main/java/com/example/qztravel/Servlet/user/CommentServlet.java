package com.example.qztravel.Servlet.user;

import com.example.qztravel.Bean.CommentBean;
import com.example.qztravel.DAO.CommentDao;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Comment")
public class CommentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CommentDao dao = new CommentDao();
        List<CommentBean> comments = dao.getAllComments();
        request.setAttribute("comments", comments);
        request.getRequestDispatcher("/comment.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String comment = request.getParameter("comment");
        String date = request.getParameter("date");
        CommentDao dao = new CommentDao();
        dao.addComment(username, comment, date);
        doGet(request, response);
    }
}