package com.retail.cart.infrastructure.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderSummary {
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal grandTotal;
}
