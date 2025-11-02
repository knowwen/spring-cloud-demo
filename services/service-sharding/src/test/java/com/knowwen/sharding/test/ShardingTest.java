package com.knowwen.sharding.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.knowwen.sharding.entity.Order;
import com.knowwen.sharding.entity.User;
import com.knowwen.sharding.mapper.OrderMapper;
import com.knowwen.sharding.mapper.UserMapper;

@SpringBootTest
public class ShardingTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testInsertUserAndOrder(){
        // User user = new User();
        // user.setUname("张三");
        // userMapper.insert(user);

        // Order order = new Order();
        // order.setOrderNo("o12345");
        // order.setUserId(1L);
        // order.setAmount(new BigDecimal(10));
        // orderMapper.insert(order);
    }

    @Test
    public void testInsertOrder(){
        Order order;
        for (int i = 0; i < 5; i++) {
            order = new Order();
            order.setOrderNo("o"+i);
            order.setUserId(1L);
            order.setAmount(new BigDecimal(10));
            orderMapper.insert(order);
        }

        for (int i = 5; i < 10; i++) {
            order = new Order();
            order.setOrderNo("o"+i);
            order.setUserId(2L);
            order.setAmount(new BigDecimal(10));
            orderMapper.insert(order);
        }

    }

    @Test
    public void testSelectOrder(){
        List<Order> orders = orderMapper.selectList(null);
        orders.forEach(System.out::println);
    }
}
