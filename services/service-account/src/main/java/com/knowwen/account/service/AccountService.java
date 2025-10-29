package com.knowwen.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.knowwen.account.mapper.AccountMapper;

@Service
public class AccountService {


    @Autowired
    private AccountMapper accountMapper;


    @Transactional
    public void decrease(Long userId,Integer money){
        accountMapper.decrease(userId, money);
    }

}
