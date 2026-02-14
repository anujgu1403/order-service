package com.retail.cart.infrastructure.mapper;

import com.retail.cart.domain.model.CartItemModel;
import com.retail.cart.infrastructure.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemModelToOrderItemMapper {

    public OrderItem apply(CartItemModel cartItemModel){
        return OrderItem.builder()
                .cartItemId(cartItemModel.getCartItemId())
                .productId(cartItemModel.getProductId())
                .quantity(cartItemModel.getQuantity())
                .unitPrice(cartItemModel.getUnitPrice())
                .imageUrl(cartItemModel.getImageUrl())
                .description(cartItemModel.getDescription())
                .productName(cartItemModel.getProductName())
                .createdDate(cartItemModel.getCreatedDate())
                .build();
    }
}
