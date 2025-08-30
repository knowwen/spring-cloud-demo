package com.knowwen.service.impl;

import org.springframework.stereotype.Service;

import com.knowwen.order.bean.Order;
import com.knowwen.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public Order createOrder(Long userId, Long productId) {
        Order order = new Order();
        return order;
    }

}
