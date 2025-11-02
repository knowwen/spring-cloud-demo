package com.knowwen.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.knowwen.auth.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
