package com.knowwen.interceptor;

import java.util.UUID;

import org.springframework.stereotype.Component;

import feign.RequestInterceptor;


@Component
public class XTokenInterceptor implements RequestInterceptor {

    @Override
    public void apply(feign.RequestTemplate requestTemplate) {
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }

}
