package com.example.hnsc.services;

import com.example.hnsc.models.Category;
import com.example.hnsc.repositories.CategoryRepo;
import com.example.hnsc.repositories.ICategoryRepo;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService{
    @Override
    public List<Category> selectAll() {
        try {
            return new CategoryRepo().selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
