package com.example.hnsc.services.category;

import com.example.hnsc.models.Category;
import com.example.hnsc.repositories.category.CategoryRepo;
import com.example.hnsc.repositories.category.ICategoryRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepo categoryRepo = new CategoryRepo();

    @Override
    public List<Category> selectAll() {
        try {
            return new CategoryRepo().selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void validate(Category category) {
        if (category.getName().isEmpty()) {
            category.addError("name", "Tên không được để trống");
        }
    }

    public void insert(Category category) {
        validate(category);
        if (category.getErrors().isEmpty()) {
            categoryRepo.insertA(category);
        }
    }

    public Category findById(int id) {
        return categoryRepo.findById(id);
    }

    public void deleteCategory(int id) throws SQLException {
        categoryRepo.deleteCategory(id);
    }

    @Override
    public void updateCategory(Category category) {
        validate(category);
        if (category.getErrors().isEmpty()) {
            categoryRepo.updateCategory(category);
        }
    }


}
