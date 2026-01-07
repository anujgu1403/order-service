package com.retail.checkout.infrastructure.mapper;

import com.retail.checkout.domain.model.CartModel;
import com.retail.checkout.infrastructure.entity.OrderEntity;
import com.retail.checkout.infrastructure.helper.OrderUtilHelper;
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
