package com.retail.cart.infrastructure.repository;

import com.retail.cart.domain.model.CartModel;
import reactor.core.publisher.Mono;

public interface OrderRepository {
    Mono<CartModel> submitOrder(CartModel cartModel);

}