package com.knowwen.controller;

import com.knowwen.product.bean.Product;
import com.knowwen.service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long id,HttpServletRequest request) {
        String header = request.getHeader("X-Token");;
        System.out.println("header:" + header);
        System.out.println("get product");
        return productService.getProduct(id);
    }
}
