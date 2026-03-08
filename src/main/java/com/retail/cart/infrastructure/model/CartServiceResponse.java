package com.retail.cart.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retail.cart.application.model.CartItem;
import com.retail.cart.application.model.CartSummary;
import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartServiceResponse {
    private Long cartId;
    private Long userId;
    private LocalDateTime createdDate;
    private boolean isActive;
    private List<CartItem> cartItems;
    private CartSummary cartSummary;
}