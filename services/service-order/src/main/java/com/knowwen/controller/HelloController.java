package com.knowwen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {

    @Value("${order.timeout}")
    String orderTimeout;

    @Value("${order.auto-confirm}")
    String orderAutoConfirm;

    @GetMapping("config")
    public String getConfig(){
        return "order.timeout="+orderTimeout+",order.auto-confirm="+orderAutoConfirm;
    }

    @GetMapping("/")
    public String index() {
        System.out.println("Hello Order service");
        return "Hello Order service";
    }
}
