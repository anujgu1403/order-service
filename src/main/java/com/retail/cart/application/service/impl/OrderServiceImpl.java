package com.retail.cart.application.service.impl;

import com.retail.cart.application.mapper.CartModelToCartMapper;
import com.retail.cart.application.mapper.CartToCartModelMapper;
import com.retail.cart.application.model.Cart;
import com.retail.cart.application.service.OrderService;
import com.retail.cart.domain.operation.CartTotalsOperations;
import com.retail.cart.infrastructure.order.OrderConnector;
import com.retail.cart.infrastructure.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public Cart submitOrder(Cart cart) {
        return Optional.ofNullable(cart)
                .map(cart1->cartToCartModelMapper.apply(cart))
                .map(CartTotalsOperations::calculateCartSummary)
                .map(cartModel->orderRepository.submitOrder(cartModel))
                .map(cartModel -> orderConnector.pushOrderToKafka(cartModel))
                .map(CartTotalsOperations::calculateCartSummary)
                .map(cartModel -> cartModelToCartMapper.apply(cartModel))
                .orElse(cart);
    }
}