package com.example.hnsc.repositories.order;

import com.example.hnsc.models.Cart;
import com.example.hnsc.models.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderRepo {
    List<Order> selectAll() throws SQLException;

    void insertOrder(Cart cart) throws SQLException;
}
