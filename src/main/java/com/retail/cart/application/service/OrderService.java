package com.retail.cart.application.service;

import com.retail.cart.application.model.Cart;

public interface OrderService {
    Cart submitOrder(Cart cart);

}