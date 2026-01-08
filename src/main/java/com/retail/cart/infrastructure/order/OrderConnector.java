package com.retail.cart.infrastructure.order;

import com.retail.cart.domain.model.CartModel;

public interface OrderConnector {
    CartModel pushOrderToKafka(CartModel cartModel);
}
