package com.retail.cart.infrastructure.client.integrator;

import com.retail.cart.domain.model.CartItemModel;
import com.retail.cart.domain.model.CartModel;
import com.retail.cart.infrastructure.client.connector.CartConnectorImpl;
import com.retail.cart.infrastructure.mapper.CartServiceResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CartIntegratorImpl implements CartIntegrator {

    @Autowired
    private CartConnectorImpl cartConnector;

    @Autowired
    private CartServiceResponseMapper cartServiceResponseMapper;

    public Mono<CartModel> integrate(CartModel cartModel){
        return Mono.just(cartModel)
                .flatMap(cartId->cartConnector.getCartById(cartModel.getCartId()))
                .map(response -> cartServiceResponseMapper.apply(response, cartModel))
                .log("Cart service called.");

    }
}
