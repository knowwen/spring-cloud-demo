package com.knowwen.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_authorities")
public class Authorities {
    private Long userId;
    private String authority;
}
