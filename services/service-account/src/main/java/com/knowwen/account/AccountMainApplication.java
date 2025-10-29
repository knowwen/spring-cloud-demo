package com.knowwen.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.knowwen.account.mapper")
@EnableTransactionManagement
public class AccountMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountMainApplication.class, args);
    }
}
