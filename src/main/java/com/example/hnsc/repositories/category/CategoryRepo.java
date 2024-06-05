package com.example.hnsc.repositories.category;

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

    @Override
    public void insertA(Category category) {
        try {
            Connection connection = new DBConnect().getConnection();
            String sql = "Insert into categories(name,avatar,description) value (?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getAvatar());
            preparedStatement.setString(3, category.getDescription());
            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public Category findById(int id) {
        try {
            Connection connection = new DBConnect().getConnection();
            String sql = "Select * From categories where id=?";
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }return null;

    }

}
