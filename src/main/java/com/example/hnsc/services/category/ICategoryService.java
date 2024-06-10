package com.example.hnsc.services.category;

import com.example.hnsc.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<Category> selectAll();

    void insert(Category category);

    void deleteCategory(int id) throws SQLException;

    void updateCategory(Category category);
}
