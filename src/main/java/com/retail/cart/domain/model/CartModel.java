package com.retail.checkout.domain.model;

import lombok.*;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
    private Long cartId;
    private Long userId;
    private OffsetDateTime createdDate;
    private boolean isActive;
    private List<CartItemModel> cartItemModels;
    private CartSummaryModel cartSummaryModel;
    private Long orderId;
    private String currency;
    private String paymentStatus;
    private String paymentMethod;
}