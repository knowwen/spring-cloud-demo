package com.knowwen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.knowwen.order.bean.Order;
import com.knowwen.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("create/order")
    public Order createOrder(@RequestParam("userId") Long userId,@RequestParam("productId") Long productId){
        Order order = orderService.createOrder(userId,productId);
        return order;
    }

}
