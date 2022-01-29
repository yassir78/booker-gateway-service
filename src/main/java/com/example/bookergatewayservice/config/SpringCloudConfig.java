package com.example.bookergatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("", r -> r.path("/api/v1/customerOrder/**")
                        .uri("lb://ORDER-SERVICE")
                )
                .route("", r -> r.path("/api/v1/account/**")
                        .uri("lb://ACCOUNT-SERVICE"))
                .route("", r -> r.path("/api/v1/payment/**")
                        .uri("lb://PAYMENT-SERVICE"))
                .build();
    }
}
