package com.example.hnsc.repositories.user;

import com.example.hnsc.database.DBConnect;
import com.example.hnsc.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    public User findUserByEmailAndPassword(String email, String password) {
        Connection connect = new DBConnect().getConnection();
        String sql = "select * from user where email = ? and password = ? limit 1;";
        try {
            PreparedStatement abc = connect.prepareStatement(sql);
            abc.setString(1, email);
            abc.setString(2, password);
            ResultSet rs = abc.executeQuery();
            User user = new User();
            while(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

