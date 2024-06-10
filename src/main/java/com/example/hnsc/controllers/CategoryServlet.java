package com.example.hnsc.controllers;


import com.example.hnsc.models.Category;
import com.example.hnsc.services.category.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/admin/categories/*")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryService();

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
                updateCategory(req, resp);
                break;


        }
    }

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
                showFormCreate(req, resp);
                break;
            case "/delete":
                deleteCategory(req, resp);
                break;
            case "/update":
                showFormUpdate(req, resp);
                break;

        }
    }

    private void insertCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Category category = new Category();
        category.setName(req.getParameter("name"));
        category.setAvatar(req.getParameter("avatar"));
        category.setDescription(req.getParameter("description"));
        categoryService.insert(category);
        if (category.getErrors().isEmpty()) {
            req.setAttribute("noti", "Thêm phân loại thành công!");
            showListCategory(req, resp);
        } else {
            req.setAttribute("category", category);
            req.getRequestDispatcher("/views/category/form.jsp").forward(req, resp);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category = new Category();
        req.setAttribute("category", category);
        req.getRequestDispatcher("/views/category/form.jsp").forward(req, resp);
    }

    private void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category = new Category();
        category.setName(req.getParameter("name"));
        category.setAvatar(req.getParameter("avatar"));
        category.setDescription(req.getParameter("description"));
        category.setId(Integer.parseInt(req.getParameter("id")));
        categoryService.updateCategory(category);

        if (category.getErrors().isEmpty()) {
            req.setAttribute("noti", "Cập nhật phân loại thành công!");
            showListCategory(req, resp);
        } else {
            req.setAttribute("category", category);
            req.getRequestDispatcher("/views/category/form.jsp").forward(req, resp);
        }

    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryService.findById(id);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/views/category/form.jsp").forward(req, resp);

    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            categoryService.deleteCategory(id);
            req.setAttribute("noti", "Xóa phân loại thành công!");

        } catch (SQLException e) {
            req.setAttribute("error", "Không thể xóa phân loại này vì có sản phẩm thuộc phân loại này");
        }
        showListCategory(req, resp);
    }


    private void showListCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.selectAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
    }


}
