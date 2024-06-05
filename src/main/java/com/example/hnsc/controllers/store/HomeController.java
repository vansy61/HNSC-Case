package com.example.hnsc.controllers.store;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "HomeController", urlPatterns = "/store")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        req.getRequestDispatcher("/views/store/home.jsp").forward(req, resp);
    }
}
