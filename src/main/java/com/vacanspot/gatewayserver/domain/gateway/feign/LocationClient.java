package com.vacanspot.gatewayserver.domain.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "locationClient", url = "http://localhost:8081")
public interface LocationClient {
    @GetMapping("/location")
    String getLocation(
            @RequestParam("x") String x,
            @RequestParam("y") String y
    );
}
