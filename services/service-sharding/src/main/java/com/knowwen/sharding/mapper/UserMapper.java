package com.knowwen.sharding.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.knowwen.sharding.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{

}
