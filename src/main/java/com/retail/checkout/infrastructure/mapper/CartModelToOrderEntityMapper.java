package com.retail.checkout.infrastructure.mapper;

import com.retail.checkout.domain.model.CartModel;
import com.retail.checkout.infrastructure.entity.OrderEntity;
import com.retail.checkout.infrastructure.helper.OrderUtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class CartModelToOrderEntityMapper {

    public OrderEntity apply(CartModel cartModel) {
        return OrderEntity.builder()
                .userId(cartModel.getUserId())
                .currency(cartModel.getCurrency())
                .paymentMethod(cartModel.getPaymentMethod())
                .paymentStatus(cartModel.getPaymentStatus())
                .cartItems(OrderUtilHelper.mapToString(cartModel))
                .build();

    }
}
