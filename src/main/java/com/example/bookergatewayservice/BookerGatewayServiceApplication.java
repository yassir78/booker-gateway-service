package com.example.bookergatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookerGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookerGatewayServiceApplication.class, args);
    }

}
