package com.example.hnsc.services.order;

import com.example.hnsc.models.Cart;
import com.example.hnsc.models.Order;
import com.example.hnsc.repositories.order.IOrderRepo;
import com.example.hnsc.repositories.order.OrderRepo;

import java.sql.SQLException;
import java.util.List;

public class OrderService implements IOrderService {
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
    public void insertOrder(Cart cart) {
        validate(cart);
        if (cart.getErrors().isEmpty()) {
            try {
                orderRepo.insertOrder(cart);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void validate(Cart cart) {
        System.out.println(cart.getAddress().getName());
        if (cart.getAddress().getName().isEmpty()) {
            cart.addError("address_name", "Tên không được để trống");
        }

        if (cart.getAddress().getPhoneNumber().isEmpty()) {
            cart.addError("address_phone", "Phone không được để trống");
        }

        if (cart.getAddress().getEmail().isEmpty()) {
            cart.addError("address_email", "Email không được để trống");
        }

        if (cart.getAddress().getAddress().isEmpty()) {
            cart.addError("address_address", "Địa chỉ không được để trống");
        }
    }


}
