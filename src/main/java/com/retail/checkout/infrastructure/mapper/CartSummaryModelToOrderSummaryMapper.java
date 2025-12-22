package com.retail.checkout.infrastructure.mapper;

import com.retail.checkout.domain.model.CartSummaryModel;
import com.retail.checkout.infrastructure.model.OrderSummary;
import org.springframework.stereotype.Component;

@Component
public class CartSummaryModelToOrderSummaryMapper {
    public OrderSummary apply(CartSummaryModel cartSummaryModel){
        return OrderSummary.builder()
                .subtotal(cartSummaryModel.getSubtotal())
                .tax(cartSummaryModel.getTax())
                .grandTotal(cartSummaryModel.getGrandTotal())
                .build();
    }
}

