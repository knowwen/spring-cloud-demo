package com.knowwen.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.knowwen.order.bean.Orders;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders>{

    @Insert("INSERT INTO orders(user_id, product_id, count, money) VALUES(#{userId}, #{productId}, #{count}, #{count}*100)")
    void insertOrder(Long userId, Long productId, Integer count);

}
