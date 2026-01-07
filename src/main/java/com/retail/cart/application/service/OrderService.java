package com.retail.checkout.application.service;

import com.retail.checkout.application.model.Cart;

public interface OrderService {
    Cart submitOrder(Cart cart);

}