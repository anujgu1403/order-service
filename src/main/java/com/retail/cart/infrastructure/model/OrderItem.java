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
    private int quantity;
    private Long cartId;
    private Long productId;
    private String productName;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private Integer categoryId;
    private OffsetDateTime createdDate;
}
