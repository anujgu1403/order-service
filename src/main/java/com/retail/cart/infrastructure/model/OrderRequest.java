package com.retail.cart.infrastructure.model;

import lombok.*;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long cartId;
    private Long userId;
    private OffsetDateTime createdDate;
    private boolean isActive;
    private List<OrderItem> orderItems;
    private OrderSummary orderSummary;
    private Long orderId;
    private String currency;
    private String paymentStatus;
    private String paymentMethod;
}
