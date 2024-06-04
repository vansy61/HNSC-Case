package com.example.hnsc.services;

import com.example.hnsc.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<Category> selectAll();
}
