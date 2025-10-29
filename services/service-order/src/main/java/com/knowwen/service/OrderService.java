package com.knowwen.service;


import com.knowwen.order.bean.Order;

public interface OrderService {

    Order createOrder(Long userId, Long productId);

    void create(Long userId, Long productId, Integer count);
}
