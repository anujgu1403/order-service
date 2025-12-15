package com.retail.checkout.infrastructure.mapper;

import com.retail.checkout.domain.model.CartModel;
import com.retail.checkout.infrastructure.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderEntityToCartModelMapper {


    public CartModel apply(OrderEntity orderEntity){
        return CartModel.builder()
                .orderId(orderEntity.getId())
                .userId(orderEntity.getUserId())
                .createdDate(orderEntity.getCreatedAt().toLocalDateTime())
                .paymentMethod(orderEntity.getPaymentMethod())
                .paymentStatus(orderEntity.getPaymentStatus())
                .build();

    }
}
