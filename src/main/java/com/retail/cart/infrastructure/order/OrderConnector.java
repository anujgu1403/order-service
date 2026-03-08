package com.retail.cart.infrastructure.order;

import com.retail.cart.domain.model.CartModel;
import reactor.core.publisher.Mono;

public interface OrderConnector {
    Mono<CartModel> pushOrderToKafka(CartModel cartModel);
}
