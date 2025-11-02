package com.knowwen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;

@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discovery;

    @Autowired
    private NacosServiceDiscovery nacosServiceDiscovery;

    @GetMapping("discovery/client")
    public List<String> test(){
        List<String> services = discovery.getServices();
        return services;
    }

    @GetMapping("discovery/client/{service}")
    public List<ServiceInstance> service(@PathVariable("service") String service){
        List<ServiceInstance> instances = discovery.getInstances(service);
        return instances;

    }

    @GetMapping("nacos/serviceDiscovery")
    public  List<String> nacosServiceDiscoveryAll() throws NacosException{
        List<String> services = nacosServiceDiscovery.getServices();
        return services;
    }

    @GetMapping("nacos/serviceDiscovery/{service}")
    public List<ServiceInstance> serviceInstance(@PathVariable("service") String service) throws NacosException{
        List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(service);
        return instances;
    }



}
