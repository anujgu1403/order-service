package com.retail.cart.domain.operation;


import com.retail.cart.domain.model.CartItemModel;
import com.retail.cart.domain.model.CartModel;
import com.retail.cart.domain.model.CartSummaryModel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

@NoArgsConstructor
public final class CartTotalsOperations {

    public static CartModel calculateCartSummary(CartModel cartModel) {

        CartSummaryModel cartSummaryModel = Optional.ofNullable(cartModel.getCartSummaryModel())
                .orElse(new CartSummaryModel());

        BigDecimal subTotal = Optional.of(cartModel)
                .map(cartModel1 -> cartModel1.getCartItemModels()
                        .stream()
                        .map(cartItemModel ->
                                cartItemModel.getUnitPrice()
                                        .multiply(BigDecimal.valueOf(cartItemModel.getQuantity())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .orElse(BigDecimal.ZERO);


        BigDecimal totalTax = Optional.of(cartModel)
                .map(cartModel1 -> cartModel1.getCartItemModels()
                        .stream()
                        .map(CartItemModel::getTax)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .orElse(BigDecimal.ZERO);

        cartSummaryModel.setSubtotal(subTotal);
        cartSummaryModel.setTax(totalTax);
        cartSummaryModel.setGrandTotal(subTotal.add(totalTax));
        cartModel.setCartSummaryModel(cartSummaryModel);
        return cartModel;
    }
}