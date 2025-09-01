package com.knowwen.service.impl;

import com.knowwen.feign.ProductFeign;
import com.knowwen.order.bean.Order;
import com.knowwen.product.bean.Product;
import com.knowwen.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProductFeign productFeign;

    @Override
    public Order createOrder(Long userId, Long productId) {
        Order order = new Order();

        Product product = productFeign.getProduct(productId);

        order.setUserId(userId);
        order.setId(10);
        order.setAddress("港边乡");
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setProducts(Arrays.asList(product));
        order.setNickName("knowwen");
        return order;
    }

    private Product getProductFromRemoteWithLoadBalancerAnnotation(Long productId) {
        String url = "http://service-product/product/"+productId;
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    private Product getProductFromRemoteWithLoadBalancer(Long productId) {
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        String url = "http://"+choose.getHost()+":"+choose.getPort()+"/product/"+productId;
        log.info("url:{}",url);
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    private Product getProductFromRemote(Long productId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance serviceInstance = instances.get(0);
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/"+productId;
        log.info("url:{}",url);
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

}
