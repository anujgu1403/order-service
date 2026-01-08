package com.retail.cart.application.mapper;

import com.retail.cart.application.model.CartSummary;
import com.retail.cart.domain.model.CartSummaryModel;
import org.springframework.stereotype.Component;

@Component
public class CartSummaryModelToCartSummaryMapper {
    public CartSummary apply(CartSummaryModel cartSummaryModel){
        return CartSummary.builder()
                .tax(cartSummaryModel.getTax())
                .subtotal(cartSummaryModel.getSubtotal())
                .grandTotal(cartSummaryModel.getGrandTotal())
                .build();
    }
}

