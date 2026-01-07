package com.retail.checkout.infrastructure.repository;

import com.retail.checkout.domain.model.CartModel;

public interface OrderRepository {
    CartModel submitOrder(CartModel cartModel);

}