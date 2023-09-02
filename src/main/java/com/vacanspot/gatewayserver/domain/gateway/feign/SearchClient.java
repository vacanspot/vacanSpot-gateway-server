package com.vacanspot.gatewayserver.domain.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "searchClient", url = "http://localhost:8082")
public interface SearchClient {
    @GetMapping("/search")
    List<String> getRecommendedImages(
            @RequestParam("query") String query
    );
}
