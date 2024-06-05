package com.example.hnsc.controllers;


import com.example.hnsc.models.Category;
import com.example.hnsc.services.category.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/admin/categories/*")
public class CategoryServlet extends HttpServlet {
private  CategoryService categoryService =new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showListCategory(req, resp);
                break;
            case "/create":
                showFormCreateCategory(req, resp);
                break;
            case "delete":
                deleteProduct(req,resp);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                insertCategory(req, resp);
                break;
            case "/update":
                break;


        }
    }
    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id")) ;
        categoryService.findById(id);
    }
    private void insertCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String avatar = req.getParameter("avatar");
        String description = req.getParameter("description");
        Category category = new Category();
        category.setName(name);
        category.setAvatar(avatar);
        category.setDescription(description);
        List<String> err = categoryService.validate(category);
        if(err.isEmpty()){
            categoryService.insert(category);
            resp.sendRedirect("/admin/categories/list");
        }
        else {
            req.setAttribute("err",err);
            req.getRequestDispatcher("/views/category/create.jsp").forward(req, resp);
        }
    }

    private void showFormCreateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/category/create.jsp").forward(req, resp);
    }

    private void showListCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.selectAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
    }


}
