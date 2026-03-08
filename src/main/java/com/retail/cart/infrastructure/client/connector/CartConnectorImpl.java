package com.retail.cart.infrastructure.client.connector;


import com.retail.cart.infrastructure.config.WebClientConfig;
import com.retail.cart.infrastructure.model.CartServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CartConnectorImpl implements CartConnector {

  @Autowired
  private WebClientConfig webClientConfig;

    public Mono<CartServiceResponse> getCartById(Long cartId) {
        return webClientConfig.getCartWebClient()
                .get()
                .uri("/{cartId}", cartId)
                .retrieve()
                .bodyToMono(CartServiceResponse.class);


    }
}