package com.example.bookergatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/payment-fallback")
    public String paymentFallback() {
        return "Payment service is not available";
    }

    @GetMapping("/account-fallback")
    public String accountFallback() {
        return "Account service is not available";
    }
    
    @GetMapping("/order-fallback")
    public String orderFallback() {
        return "Order service is not available";
    }
}

