package com.knowwen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class LoadBalancerTest {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Test
    public void loadbalancerTest() {
        ServiceInstance choose = loadBalancerClient.choose("service-order");
        System.out.println("host="+choose.getHost()+",port="+choose.getPort());
        choose = loadBalancerClient.choose("service-order");
        System.out.println("host="+choose.getHost()+",port="+choose.getPort());
        choose = loadBalancerClient.choose("service-order");
        System.out.println("host="+choose.getHost()+",port="+choose.getPort());
        choose = loadBalancerClient.choose("service-order");
        System.out.println("host="+choose.getHost()+",port="+choose.getPort());
        choose = loadBalancerClient.choose("service-order");
        System.out.println("host="+choose.getHost()+",port="+choose.getPort());

    }
}
