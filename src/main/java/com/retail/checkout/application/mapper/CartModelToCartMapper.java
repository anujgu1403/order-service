package com.retail.checkout.application.mapper;

import com.retail.checkout.application.model.Cart;
import com.retail.checkout.domain.model.CartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartModelToCartMapper {

    @Autowired
    CartItemModelToCartItemMapper cartItemModelToCartItemMapper;

    public Cart apply(CartModel cartModel) {

        return Cart.builder()
                .orderId(cartModel.getOrderId())
                .userId(cartModel.getUserId())
                .createdDate(cartModel.getCreatedDate())
                .paymentMethod(cartModel.getPaymentMethod())
                .paymentStatus(cartModel.getPaymentStatus())
                .build();
    }
}
