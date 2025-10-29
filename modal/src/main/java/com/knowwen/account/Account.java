package com.knowwen.account;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Account {
    private Long id;
    private Long userId;
    private BigDecimal balance;
     
}
