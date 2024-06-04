package com.example.hnsc.repositories;

import com.example.hnsc.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryRepo {

    List<Category> selectAll() throws SQLException;


}
