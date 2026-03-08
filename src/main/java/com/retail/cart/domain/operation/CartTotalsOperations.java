package com.retail.cart.domain.operation;


import com.retail.cart.domain.model.CartItemModel;
import com.retail.cart.domain.model.CartModel;
import com.retail.cart.domain.model.CartSummaryModel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

@NoArgsConstructor
public final class CartTotalsOperations {

    public static CartModel calculateCartSummary(CartModel cartModel) {

        CartSummaryModel cartSummaryModel = Optional.ofNullable(cartModel.getCartSummaryModel())
                .orElse(new CartSummaryModel());

        BigDecimal subTotal = Optional.of(cartModel)
                .map(cartModel1 -> Optional.ofNullable(cartModel1.getCartItemModels())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(cartItemModel ->
                        {
                            BigDecimal price = Optional.ofNullable(cartItemModel.getUnitPrice())
                                    .orElse(BigDecimal.ZERO);

                            Integer qty = Optional.of(cartItemModel.getQuantity())
                                    .orElse(0);

                            return price.multiply(BigDecimal.valueOf(qty));
                        })
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .orElse(BigDecimal.ZERO);


        BigDecimal totalTax = Optional.of(cartModel)
                .map(cartModel1 -> Optional.ofNullable(cartModel1.getCartItemModels())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(cartItemModel -> {
                            return Optional.ofNullable(cartItemModel.getTax())
                                    .orElse(BigDecimal.ZERO);
                        })
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .orElse(BigDecimal.ZERO);

        cartSummaryModel.setSubtotal(subTotal);
        cartSummaryModel.setTax(totalTax);
        cartSummaryModel.setGrandTotal(subTotal.add(totalTax));
        cartModel.setCartSummaryModel(cartSummaryModel);
        return cartModel;
    }
}