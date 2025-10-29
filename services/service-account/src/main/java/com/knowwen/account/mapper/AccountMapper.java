package com.knowwen.account.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.knowwen.account.Account;

@Mapper
public interface AccountMapper extends BaseMapper<Account>{

    @Update("UPDATE account SET balance = balance - #{money} WHERE user_id = #{userId}")
    void decrease(Long userId, Integer money);
}
