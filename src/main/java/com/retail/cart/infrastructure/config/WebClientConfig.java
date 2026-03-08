package com.retail.cart.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${cart.service.url}")
    private String cartBaseUrl;

    @Bean
    public WebClient getCartWebClient() {
        return WebClient.builder()
                .baseUrl(cartBaseUrl)
                .build();
    }
}