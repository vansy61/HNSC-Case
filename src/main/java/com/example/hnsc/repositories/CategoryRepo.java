package com.example.hnsc.repositories;

import com.example.hnsc.database.DBConnect;
import com.example.hnsc.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo {

    @Override
    public List<Category> selectAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = "select * from categories";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            category.setAvatar(rs.getString("avatar"));
            category.setDescription(rs.getString("description"));
            categories.add(category);
        }
        return categories;
    }

}
