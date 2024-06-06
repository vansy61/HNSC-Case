package com.example.hnsc.services.order;

import com.example.hnsc.models.Order;
import com.example.hnsc.repositories.Order.IOrderRepo;
import com.example.hnsc.repositories.Order.OrderRepo;

import java.sql.SQLException;
import java.util.List;

public class OrderService implements IOrderService{
    IOrderRepo orderRepo = new OrderRepo();

    @Override
    public List<Order> selectAll() {
        try {
            return orderRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String insertOrder() {
        try {
            return orderRepo.insertOrder();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
