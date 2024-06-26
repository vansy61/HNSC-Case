package com.example.hnsc.services.order;

import com.example.hnsc.models.Cart;
import com.example.hnsc.models.Order;

import java.util.List;

public interface IOrderService {
    List<Order> selectAll();

    void insertOrder(Cart cart);
}
