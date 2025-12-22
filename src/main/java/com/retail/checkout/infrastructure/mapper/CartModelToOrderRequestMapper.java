package com.retail.checkout.infrastructure.mapper;

import com.retail.checkout.domain.model.CartModel;
import com.retail.checkout.infrastructure.model.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartModelToOrderRequestMapper {
    @Autowired
    private CartItemModelToOrderItemMapper cartItemModelToOrderItemMapper;

    public OrderRequest apply(CartModel cartModel){
        return OrderRequest.builder()
                .orderId(cartModel.getOrderId())
                .cartId(cartModel.getCartId())
                .createdDate(cartModel.getCreatedDate())
                .currency(cartModel.getCurrency())
                .userId(cartModel.getUserId())
                .isActive(cartModel.isActive())
                .paymentMethod(cartModel.getPaymentMethod())
                .paymentStatus(cartModel.getPaymentStatus())
                .orderItems(cartModel.getCartItemModels().stream()
                        .map(cartItemModel -> cartItemModelToOrderItemMapper.apply(cartItemModel))
                        .toList())
                .build();
    }
}
