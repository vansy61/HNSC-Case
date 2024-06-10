package com.example.hnsc.repositories.order;

import com.example.hnsc.database.DBConnect;
import com.example.hnsc.models.Cart;
import com.example.hnsc.models.CartItem;
import com.example.hnsc.models.Order;
import com.example.hnsc.models.OrderAddress;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public void insertOrder(Cart cart) throws SQLException {
        Connection connection = new DBConnect().getConnection();
        String number = randomNumber();
        String orderSql = "insert into orders(number, total) value(?,?)";
        PreparedStatement orderPs = connection.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
        orderPs.setString(1, number);
        orderPs.setDouble(2, cart.getTotalPrice());
        orderPs.executeUpdate();
        ResultSet orderGenerateKeys = orderPs.getGeneratedKeys();
        int orderId = 0;
        if (orderGenerateKeys.next()) {
            orderId = orderGenerateKeys.getInt(1);
        }

        String addressSql = "insert into addresses(name, address, email, phone_number, order_id) value(?,?,?,?,?)";
        PreparedStatement addressPs = connection.prepareStatement(addressSql);
        addressPs.setString(1, cart.getAddress().getName());
        addressPs.setString(2, cart.getAddress().getAddress());
        addressPs.setString(3, cart.getAddress().getEmail());
        addressPs.setString(4, cart.getAddress().getPhoneNumber());
        addressPs.setInt(5, orderId);
        addressPs.executeUpdate();

        String orderItemSql = "insert into order_items(product_id, quaitity, price, order_id) value(?,?,?,?)";
        PreparedStatement orderItemPs = connection.prepareStatement(orderItemSql);
        for (CartItem item : cart.getItems()) {
            orderItemPs.setInt(1, item.getProduct().getId());
            orderItemPs.setInt(2, item.getQuantity());
            orderItemPs.setDouble(3, item.getProduct().getPrice());
            orderItemPs.setInt(4, orderId);
            orderItemPs.executeUpdate();
        }

        connection.close();
    }

    private String randomNumber() {
        Random r = new Random(System.currentTimeMillis());
        int n = 10000 + r.nextInt(20000);
        return "O" + n;
    }

}
