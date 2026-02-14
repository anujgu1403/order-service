package com.retail.cart.application.mapper;

import com.retail.cart.application.model.CartItem;
import com.retail.cart.domain.model.CartItemModel;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

@Component
public class CartItemToCartItemModelMapper {

    public CartItemModel apply(CartItem cartItem){
        return CartItemModel.builder()
                .cartId(cartItem.getCartId())
                .cartItemId(cartItem.getCartItemId())
                .productId(cartItem.getProductId())
                .quantity(cartItem.getQuantity())
                .createdDate(cartItem.getCreatedDate())
                .unitPrice(cartItem.getUnitPrice())
                .imageUrl(cartItem.getImageUrl())
                .description(cartItem.getDescription())
                .productName(cartItem.getProductName())
                .tax(Optional.ofNullable(cartItem.getTax()).orElse(BigDecimal.ZERO))
                .build();
    }
}
