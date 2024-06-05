package com.example.hnsc.controllers;

import com.example.hnsc.models.User;
import com.example.hnsc.services.user.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="AuthorServlet",urlPatterns = {"/login"})
public class AuthorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if(url.equals("/login")){
            showFormLogin(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if(url.equals("/login")){
            checkLogin(req, resp);
        }
    }

    private void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new UserService().getUserByEmailAndPassword(email, password);

        if(user.getId() != 0) {
            HttpSession session = req.getSession();
            session.setAttribute("user_id", user.getId());
            resp.sendRedirect("/admin/categories/list");
        }else {
            System.out.println("khong dung");
        }

    }

    private void showFormLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/author/login.jsp").forward(req, resp);
    }
}