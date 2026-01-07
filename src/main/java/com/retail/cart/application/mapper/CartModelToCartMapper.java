package com.retail.checkout.application.mapper;

import com.retail.checkout.application.model.Cart;
import com.retail.checkout.domain.model.CartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CartModelToCartMapper {

    @Autowired
    private CartItemModelToCartItemMapper cartItemModelToCartItemMapper;

    @Autowired
    private CartSummaryModelToCartSummaryMapper cartSummaryModelToCartSummaryMapper;

    public Cart apply(CartModel cartModel) {

        return Cart.builder()
                .orderId(cartModel.getOrderId())
                .userId(cartModel.getUserId())
                .createdDate(cartModel.getCreatedDate())
                .paymentMethod(cartModel.getPaymentMethod())
                .paymentStatus(cartModel.getPaymentStatus())
                .cartItems(Optional.ofNullable(cartModel.getCartItemModels())
                        .map(cartItems ->
                                cartItems.stream()
                                        .map(cartItem -> cartItemModelToCartItemMapper.apply(cartItem))
                                        .toList())
                        .orElse(null))
                .cartSummary(cartSummaryModelToCartSummaryMapper.apply(cartModel.getCartSummaryModel()))
                .build();
    }
}
