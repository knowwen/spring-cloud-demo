package com.knowwen.service.impl;

import com.knowwen.order.bean.Order;
import com.knowwen.service.OrderService;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(Long userId, Long productId) {
        Order order = new Order();
        return order;
    }

}
