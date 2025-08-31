package com.knowwen.order.bean;

import com.knowwen.product.bean.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {
    private long id;
    private BigDecimal totalAmount;
    private long userId;
    private String nickName;
    private String address;
    private List<Product> products;
}
