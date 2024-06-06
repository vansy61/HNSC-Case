package com.example.hnsc.repositories.Order;

import com.example.hnsc.database.DBConnect;
import com.example.hnsc.models.Order;
import com.example.hnsc.models.OrderAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

public class OrderRepo implements IOrderRepo {
    @Override
    public List<Order> selectAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = "select a.id as addressId,a.name as addressName, a.address,a.email,a.phone_number as phoneNumber,o.id,o.number,o.total from orders o join addresses a on a.order_id = o.id";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int orderId = rs.getInt("id");
            String orderNumber = rs.getString("number");
            double orderTotal = rs.getDouble("total");
            int addressId = rs.getInt("addressId");
            String addressName = rs.getString("addressName");
            String address = rs.getString("address");
            String email = rs.getString("email");
            String phoneNumber = rs.getString("phoneNumber");
            OrderAddress orderAddress = new OrderAddress(addressId, addressName, address, email, phoneNumber);
            Order order = new Order(orderId, orderNumber, orderTotal, orderAddress);
            orders.add(order);
        }
        return orders;
    }

    @Override
    public String insertOrder() throws SQLException {
        Connection connection = new DBConnect().getConnection();
        Random r = new Random(System.currentTimeMillis());
        int n = 10000 + r.nextInt(20000);
        String number = "HNSC" + n;
        String sql = "insert into orders(number,total) value(?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, number);
        ps.setDouble(2, 0);
        ps.executeUpdate();
        return number;
    }
    public Order findOrderByNumber(String number) throws SQLException {
        Connection connection = new DBConnect().getConnection();
        String sql = "select * from orders where number = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.getString(1);

        Order order = null;
        while (rs.next()) {
            order.setId(rs.getInt("id"));
            order.setNumber(rs.getString("number"));
            order.setTotal(rs.getDouble("total"));
        }
        return order;
    }
}
