package com.knowwen.oauth2.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.knowwen.auth.entity.Authorities;
import com.knowwen.auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthoritiesService authoritiesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        User user = userService.getOne(queryWrapper);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return org.springframework.security.core.userdetails.User
                        .withUsername(user.getUserName())
                        .password(user.getPassword())
                .authorities(getAuthorities(user.getId()))
                .build();
    }

    public List<SimpleGrantedAuthority> getAuthorities(Long userId){
        QueryWrapper<Authorities> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<Authorities> authorities = authoritiesService.list(queryWrapper);
        return authorities.stream()
                .map(item -> new SimpleGrantedAuthority(item.getAuthority())).collect(Collectors.toList());
    }
}
