package com.retail.checkout.application.service.impl;

import com.retail.checkout.application.mapper.CartModelToCartMapper;
import com.retail.checkout.application.mapper.CartToCartModelMapper;
import com.retail.checkout.application.model.Cart;
import com.retail.checkout.application.service.OrderService;
import com.retail.checkout.domain.model.CartModel;
import com.retail.checkout.infrastructure.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    CartModelToCartMapper cartModelToCartMapper;

    @Autowired
    CartToCartModelMapper cartToCartModelMapper;


    @Override
    public Cart submitOrder(Cart cart) {
        CartModel cartModel = cartToCartModelMapper.apply(cart);
        return cartModelToCartMapper.apply(orderRepository.submitOrder(cartModel));
    }
}