package com.retail.cart.infrastructure.mapper;

import com.retail.cart.domain.model.CartModel;
import com.retail.cart.infrastructure.model.CartServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CartServiceResponseMapper {

    @Autowired
    private CartItemResponseMapper cartItemResponseMapper;

    public CartModel apply(CartServiceResponse cartServiceResponse, CartModel cartModel){
        return CartModel.builder()
                .cartId(cartServiceResponse.getCartId())
                .userId(cartServiceResponse.getUserId())
                .isActive(cartServiceResponse.isActive())
                .createdDate(cartServiceResponse.getCreatedDate())
                .cartItemModels(Optional.ofNullable(cartServiceResponse.getCartItems())
                        .map(cartItems ->
                                cartItems.stream()
                                        .map(cartItem -> cartItemResponseMapper.apply(cartItem))
                                        .toList())
                        .orElse(null))
                .paymentStatus(cartModel.getPaymentStatus())
                .paymentMethod(cartModel.getPaymentMethod())
                .currency(cartModel.getCurrency())
                .build();
    }
}
