package com.retail.cart.application.service.impl;

import com.retail.cart.application.mapper.CartModelToCartMapper;
import com.retail.cart.application.mapper.CartToCartModelMapper;
import com.retail.cart.application.model.Cart;
import com.retail.cart.application.service.OrderService;
import com.retail.cart.domain.operation.CartTotalsOperations;
import com.retail.cart.infrastructure.client.integrator.CartIntegrator;
import com.retail.cart.infrastructure.client.integrator.CartIntegratorImpl;
import com.retail.cart.infrastructure.order.OrderConnector;
import com.retail.cart.infrastructure.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    CartModelToCartMapper cartModelToCartMapper;

    @Autowired
    CartToCartModelMapper cartToCartModelMapper;

    @Autowired
    OrderConnector orderConnector;

    @Autowired
    private CartIntegratorImpl cartIntegrator;

    @Override
    public Mono<Cart> submitOrder(Cart cart) {
        return Mono.just(cart)
                .map(cart1->cartToCartModelMapper.apply(cart))
                .flatMap(cartModel -> cartIntegrator.integrate(cartModel))
                .map(CartTotalsOperations::calculateCartSummary)
                .flatMap(cartModel->orderRepository.submitOrder(cartModel))
                .doOnSuccess(cartModel -> orderConnector.pushOrderToKafka(cartModel))
                .map(CartTotalsOperations::calculateCartSummary)
                .map(cartModel -> cartModelToCartMapper.apply(cartModel));
    }
}