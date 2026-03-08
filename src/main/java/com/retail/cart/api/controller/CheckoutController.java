package com.retail.cart.api.controller;

import com.retail.cart.application.model.Cart;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

public interface CheckoutController {

    @PostMapping("submitcheckout")
    ResponseEntity<Mono<Cart>> submitOrder(@RequestBody Cart cart);
}
