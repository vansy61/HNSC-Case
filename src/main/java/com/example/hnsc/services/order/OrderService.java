package com.example.hnsc.services.order;

import com.example.hnsc.repositories.Order.IOrderRepo;
import com.example.hnsc.repositories.Order.OrderRepo;

public class OrderService implements IOrderService{
    IOrderRepo orderRepo = new OrderRepo();
    

}
