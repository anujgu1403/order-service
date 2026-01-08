package com.retail.cart.api.controller.impl;

import com.retail.cart.api.controller.CheckoutController;
import com.retail.cart.application.model.Cart;
import com.retail.cart.application.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class CheckoutControllerImpl implements CheckoutController {

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<Cart> submitOrder(Cart cart) {
        return ResponseEntity.ok(orderService.submitOrder(cart));
    }
}