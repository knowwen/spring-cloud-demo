package com.knowwen.service.impl;

import com.knowwen.product.bean.Product;
import com.knowwen.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProduct(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setNum(2);
        product.setPrice(new BigDecimal(10));
        product.setProductName("苹果-" + productId);
        return product;
    }
}
