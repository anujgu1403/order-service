package com.retail.cart.infrastructure.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartInfraProperties {
    @Value("${order.kafka.topic}")
    @Getter
    private String orderCaptureTopic;
}
