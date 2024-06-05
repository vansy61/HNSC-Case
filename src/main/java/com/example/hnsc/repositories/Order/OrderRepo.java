package com.example.hnsc.repositories.Order;

import com.example.hnsc.database.DBConnect;
import com.example.hnsc.models.Order;
import com.example.hnsc.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo implements IOrderRepo{
    @Override
    public List<Order> selectAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = "select * from products";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setNumber(rs.getString("number"));
            order.setTotal(rs.getDouble("total"));
            order.setAddress_id(rs.getInt("price"));
          orders.add(order);
        }
        return orders;
    }
}
