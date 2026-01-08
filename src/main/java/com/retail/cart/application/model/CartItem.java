package com.retail.cart.application.model;

import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    private Long cartItemId;
    private Long cartId;
    private Long itemNumber;
    private BigDecimal unitPrice;
    private int quantity;
    private OffsetDateTime createdDate;
    private BigDecimal tax;
}