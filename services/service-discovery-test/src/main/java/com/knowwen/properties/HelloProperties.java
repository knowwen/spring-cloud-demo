package com.knowwen.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "order.test")
@Data
public class HelloProperties {
    String hello;
    String dbUrl;
    
}
