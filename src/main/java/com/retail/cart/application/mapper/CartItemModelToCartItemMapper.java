package com.retail.checkout.application.mapper;

import com.retail.checkout.application.model.CartItem;
import com.retail.checkout.domain.model.CartItemModel;
import org.springframework.stereotype.Component;

@Component
public class CartItemModelToCartItemMapper {

    public CartItem apply(CartItemModel cartItemModel){

        return CartItem.builder()
                .cartId(cartItemModel.getCartId())
                .cartItemId(cartItemModel.getCartItemId())
                .itemNumber(cartItemModel.getItemNumber())
                .createdDate(cartItemModel.getCreatedDate())
                .unitPrice(cartItemModel.getUnitPrice())
                .quantity(cartItemModel.getQuantity())
                .tax(cartItemModel.getTax())
                .build();

    }
}
