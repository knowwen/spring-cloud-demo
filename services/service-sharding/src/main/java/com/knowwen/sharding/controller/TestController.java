package com.knowwen.sharding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knowwen.sharding.service.TestService;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("sharding/create")
    private String create(){
        testService.testInsertUserAndOrder();
        return "success";
    }
}
