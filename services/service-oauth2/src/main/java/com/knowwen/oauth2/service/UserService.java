package com.knowwen.oauth2.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.knowwen.oauth2.mapper.UserMapper;
import com.knowwen.auth.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService  extends ServiceImpl<UserMapper, User> {

}
