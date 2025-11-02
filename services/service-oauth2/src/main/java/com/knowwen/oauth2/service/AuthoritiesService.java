package com.knowwen.oauth2.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.knowwen.auth.entity.Authorities;
import com.knowwen.oauth2.mapper.AuthoritiesMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesService extends ServiceImpl<AuthoritiesMapper, Authorities> {
}
