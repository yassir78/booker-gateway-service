package com.example.bookergatewayservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class GatewayConfig {

	@Autowired
	AuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("order-service",
				r -> r.path("/api/v1/customerOrder/**").filters(f -> f.filter(filter)).uri("lb://ORDER-SERVICE"))

				.route("account-service",
						r -> r.path("/api/v1/account/**").filters(f -> f.filter(filter)).uri("lb://ACCOUNT-SERVICE"))

				.route("payment-service", r -> r.path("/api/v1/payment/**").filters(f -> f.filter(filter)).uri("lb://PAYMENT-SERVICE"))

				.build();

	}
	
	


}
