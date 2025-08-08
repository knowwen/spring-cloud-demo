package com.knowwen.controller;

import com.knowwen.properties.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    HelloProperties helloProperties;

    @GetMapping("config")
    public String getConfig(){
        return "order.timeout="+orderTimeout+",order.auto-confirm="+orderAutoConfirm;
    }

    @GetMapping("config/hello")
    public String getHelloConfig(){
        return helloProperties.getHello();
    }

    @GetMapping("/")
    public String index() {
        System.out.println("Hello Order service");
        return "Hello Order service";
    }
}
