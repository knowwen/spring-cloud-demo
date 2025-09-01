package com.knowwen;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;

@EnableFeignClients
@SpringBootApplication
public class OrderMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager){
        return args ->{
            System.out.println("===========");
            ConfigService configService = nacosConfigManager.getConfigService();
            configService.addListener(
                                "order-service.properties", "DEFAULT_GROUP", new Listener() {

                                    @Override
                                    public Executor getExecutor() {
                                        return Executors.newFixedThreadPool(4);
                                    }

                                    @Override
                                    public void receiveConfigInfo(String configInfo) {
                                        System.out.println("变化的配置信息是：" + configInfo);
                                        System.out.println("发送邮件");
                                    }
                                    
                                });
        };
    }

}
