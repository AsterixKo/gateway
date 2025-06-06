package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(p -> p.path("/api/user/**")
                        .uri("lb://user-service"))
                .route(p -> p.path("/api/product/**")
                        .uri("lb://product-service"))
                .route(p -> p.path("/api/shopping/**")
                        .uri("lb://shopping-service"))
                .build();
    }
}
