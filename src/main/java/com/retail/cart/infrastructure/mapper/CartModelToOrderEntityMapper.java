package com.retail.cart.infrastructure.mapper;

import com.retail.cart.domain.model.CartModel;
import com.retail.cart.infrastructure.entity.OrderEntity;
import com.retail.cart.infrastructure.helper.OrderUtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartModelToOrderEntityMapper {

    @Autowired
    private OrderUtilHelper orderUtilHelper;
    public OrderEntity apply(CartModel cartModel) {
        return OrderEntity.builder()
                .userId(cartModel.getUserId())
                .currency(cartModel.getCurrency())
                .paymentMethod(cartModel.getPaymentMethod())
                .paymentStatus(cartModel.getPaymentStatus())
                .cartItems(orderUtilHelper.mapToString(cartModel))
                .totalAmount(cartModel.getCartSummaryModel().getGrandTotal())
                .build();

    }
}
