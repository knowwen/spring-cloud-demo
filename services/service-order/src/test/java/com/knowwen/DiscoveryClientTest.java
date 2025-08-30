package com.knowwen;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootTest
public class DiscoveryClientTest {


    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void discoveryTest(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("========");
            System.out.println(service);
        }
    }


    @Test
    void test(){
        System.out.println("Hello");
    }

}
