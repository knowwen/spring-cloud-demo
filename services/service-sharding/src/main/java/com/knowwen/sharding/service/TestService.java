package com.knowwen.sharding.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowwen.sharding.entity.Order;
import com.knowwen.sharding.entity.User;
import com.knowwen.sharding.mapper.OrderMapper;
import com.knowwen.sharding.mapper.UserMapper;

@Service
public class TestService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    public void testInsertUserAndOrder(){
        User user = new User();
        user.setUname("张三");
        userMapper.insert(user);

        Order order = new Order();
        order.setOrderNo("o12345");
        order.setUserId(1L);
        order.setAmount(new BigDecimal(10));
        orderMapper.insert(order);
    }
}
