package com.vacanspot.gatewayserver.domain.gateway.controller;

import com.vacanspot.gatewayserver.domain.gateway.service.GatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GatewayController {
    private final GatewayService gatewayService;

    @GetMapping("/address")
    public ResponseEntity<String> getLocation(
            @RequestParam("x") String x,
            @RequestParam("y") String y
    ) {
        return ResponseEntity.ok(
                gatewayService.getLocation(x, y)
        );
    }

    @GetMapping("/recommend/images")
    public ResponseEntity<List<String>> getRecommendImages(
            @RequestParam(value = "x", required = false) String x,
            @RequestParam(value = "y", required = false) String y,
            @RequestParam(value = "q", required = false) String q
    ) {
        return ResponseEntity.ok(
                gatewayService.getRecommendImages(x, y, q)
        );
    }
}
