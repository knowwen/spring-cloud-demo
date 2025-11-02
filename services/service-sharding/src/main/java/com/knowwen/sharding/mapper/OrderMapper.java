package com.knowwen.sharding.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.knowwen.sharding.entity.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Order>{

}
