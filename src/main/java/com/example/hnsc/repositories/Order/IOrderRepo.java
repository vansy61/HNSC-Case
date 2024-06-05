package com.example.hnsc.repositories.Order;

import com.example.hnsc.models.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderRepo {
    List<Order> selectAll() throws SQLException;

}
