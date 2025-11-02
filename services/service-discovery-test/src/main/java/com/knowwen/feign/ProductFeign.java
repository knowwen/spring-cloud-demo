package com.knowwen.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knowwen.product.bean.Product;


@FeignClient(name = "service-product") // name是微服务名称
public interface ProductFeign {
    @RequestMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long id);
}
