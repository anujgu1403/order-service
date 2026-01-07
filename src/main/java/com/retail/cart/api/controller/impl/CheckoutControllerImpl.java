package com.retail.checkout.api.controller.impl;

import com.retail.checkout.api.controller.CheckoutController;
import com.retail.checkout.application.model.Cart;
import com.retail.checkout.application.service.OrderService;
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