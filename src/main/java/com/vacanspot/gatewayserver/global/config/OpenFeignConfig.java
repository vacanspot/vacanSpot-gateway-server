package com.vacanspot.gatewayserver.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.vacanspot.gatewayserver")
@Configuration
public class OpenFeignConfig {
}
