package com.retail.checkout.application.mapper;

import com.retail.checkout.application.model.CartSummary;
import com.retail.checkout.domain.model.CartSummaryModel;
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

