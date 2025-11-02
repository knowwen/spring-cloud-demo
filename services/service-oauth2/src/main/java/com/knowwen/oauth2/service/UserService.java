package com.knowwen.oauth2.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.knowwen.oauth2.mapper.UserMapper;
import com.knowwen.auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  extends ServiceImpl<UserMapper, User> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean save(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.save(entity);
    }
}
