package com.retail.cart.application.service;

import com.retail.cart.application.model.Cart;
import reactor.core.publisher.Mono;

public interface OrderService {
    Mono<Cart> submitOrder(Cart cart);

}