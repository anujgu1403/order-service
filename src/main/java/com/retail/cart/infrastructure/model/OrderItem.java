package com.retail.cart.infrastructure.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Long cartItemId;
    private Long itemNumber;
    private BigDecimal unitPrice;
    private int quantity;
    private Long cartId;
    private OffsetDateTime createdDate;
}
