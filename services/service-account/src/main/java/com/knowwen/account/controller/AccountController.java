package com.knowwen.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.knowwen.account.service.AccountService;

@RestController
public class AccountController {


    @Autowired
    private AccountService accountService;

    @GetMapping("/account/decrease")
    public String decrease(@RequestParam Long userId,@RequestParam Integer money){
        accountService.decrease(userId, money);
        return "扣减余额成功";
    }
}
