package com.knowwen.service;

import com.knowwen.order.bean.Order;

public interface OrderService {

    Order createOrder(Long userId, Long productId);

}
