package com.retail.checkout.infrastructure.mapper;

import com.retail.checkout.domain.model.CartModel;
import com.retail.checkout.infrastructure.entity.OrderEntity;
import com.retail.checkout.infrastructure.helper.OrderUtilHelper;
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
