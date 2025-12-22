package com.retail.checkout.infrastructure.mapper;

import com.retail.checkout.domain.model.CartItemModel;
import com.retail.checkout.infrastructure.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemModelToOrderItemMapper {

    public OrderItem apply(CartItemModel cartItemModel){
        return OrderItem.builder()
                .cartItemId(cartItemModel.getCartItemId())
                .itemNumber(cartItemModel.getItemNumber())
                .quantity(cartItemModel.getQuantity())
                .unitPrice(cartItemModel.getUnitPrice())
                .createdDate(cartItemModel.getCreatedDate())
                .build();
    }
}
