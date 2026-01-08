package com.retail.cart.infrastructure.mapper;

import com.retail.cart.domain.model.CartModel;
import com.retail.cart.infrastructure.entity.OrderEntity;
import com.retail.cart.infrastructure.helper.OrderUtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityToCartModelMapper {

    @Autowired
    private OrderUtilHelper orderUtilHelper;

    public CartModel apply(OrderEntity orderEntity){
        return CartModel.builder()
                .orderId(orderEntity.getId())
                .userId(orderEntity.getUserId())
                .createdDate(orderEntity.getCreatedAt())
                .currency(orderEntity.getCurrency())
                .cartItemModels(orderUtilHelper.mapToCartItems(orderEntity.getCartItems()))
                .paymentMethod(orderEntity.getPaymentMethod())
                .paymentStatus(orderEntity.getPaymentStatus())
                .build();

    }
}
