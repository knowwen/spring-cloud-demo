package com.knowwen.order.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class Orders {
    private Long id;
    private Long userId;
    private Long productId;
    private int count;
    private BigDecimal money;
    private Timestamp createTime;
}
