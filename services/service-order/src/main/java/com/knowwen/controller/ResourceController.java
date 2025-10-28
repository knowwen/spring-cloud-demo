package com.knowwen.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    /**
     * 公开接口：无需 Token，网关直接转发
     */
    @GetMapping("/public/hello")
    public String publicHello() {
        return "这是公开接口，无需登录即可访问！";
    }

    /**
     * 受保护接口：需携带有效 Token，且有 "SCOPE_resource:read" 权限
     * 通过 Authentication 对象提取 JWT 中的用户信息（如用户名、scope）
     */
    @GetMapping("/resource/hello")
    public String resourceHello(Authentication authentication) {
        // 1. 将 Authentication 转为 Jwt 对象（获取 JWT 原始信息）
        Jwt jwt = (Jwt) authentication.getPrincipal();
        
        // 2. 提取 JWT 中的字段（如用户名、scope）
        String username = jwt.getClaimAsString("sub"); // 从 JWT 的 "username" 字段获取用户名
        String scope = jwt.getClaimAsString("scope"); // 从 JWT 的 "scope" 字段获取权限范围

        // 3. 返回带用户信息的响应
        return String.format("欢迎！用户【%s】，您的权限：%s，已成功访问受保护接口！", username, scope);
    }
}