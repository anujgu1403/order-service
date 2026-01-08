package com.retail.cart.infrastructure.repository;

import com.retail.cart.domain.model.CartModel;

public interface OrderRepository {
    CartModel submitOrder(CartModel cartModel);

}