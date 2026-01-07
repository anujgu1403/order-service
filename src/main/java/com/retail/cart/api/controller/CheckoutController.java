package com.retail.checkout.api.controller;

import com.retail.checkout.application.model.Cart;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CheckoutController {

    @PostMapping("submitcheckout")
    ResponseEntity<Cart> submitOrder(@RequestBody Cart cart);
}
