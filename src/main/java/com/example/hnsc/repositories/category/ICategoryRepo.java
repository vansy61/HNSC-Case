package com.example.hnsc.repositories.category;

import com.example.hnsc.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryRepo {

    List<Category> selectAll() throws SQLException;
    public void insert();
}
