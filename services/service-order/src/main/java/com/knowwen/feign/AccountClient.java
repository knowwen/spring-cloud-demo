package com.knowwen.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-account")
public interface AccountClient {

    @GetMapping("/account/decrease")
    public String decrease(@RequestParam Long userId,@RequestParam Integer money);

}
