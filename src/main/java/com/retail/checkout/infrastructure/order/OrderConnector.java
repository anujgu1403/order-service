package com.retail.checkout.infrastructure.order;

import com.retail.checkout.domain.model.CartModel;

public interface OrderConnector {
    CartModel pushOrderToKafka(CartModel cartModel);
}
