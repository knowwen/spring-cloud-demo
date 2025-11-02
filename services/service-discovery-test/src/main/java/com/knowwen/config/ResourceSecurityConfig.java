package com.knowwen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.OAuth2ResourceServerSpec;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity // 开启 Spring Security 权限控制
public class ResourceSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/resource/**").hasAuthority("SCOPE_openid")
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwt -> jwt
                    .jwtAuthenticationConverter(jwtAuthenticationConverter())
                )
            );
        return http.build();
    }

    /**
     * 自定义 JWT 解析器：从 JWT 的 "scope" 字段提取权限，并添加 "SCOPE_" 前缀
     * （OAuth2 规范中，权限需以 "SCOPE_" 开头，与配置中的 "hasAuthority" 对应）
     */
    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        // 1. 配置 JWT 权限转换器（处理 scope 字段）
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        // 启用 scope 字段解析（默认已启用，显式配置更清晰）
        // grantedAuthoritiesConverter.setEnableScopeAuthorities(true);
        // 可选：自定义权限前缀（默认是 "SCOPE_"，建议保持默认）
        // grantedAuthoritiesConverter.setScopePrefix("ROLE_");

        // 2. 配置 JWT 认证转换器（关联权限转换器）
        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);

        return jwtConverter;
    }
}