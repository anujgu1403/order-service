package com.retail.checkout.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.core.util.Json;
import lombok.*;
import org.apache.tomcat.util.json.JSONFilter;

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
public class Cart {
    private Long cartId;
    private Long userId;
    private OffsetDateTime createdDate;
    private boolean isActive;
    private List<CartItem> cartItems;
    private CartSummary cartSummary;
    private Long orderId;
    private String currency;
    private String paymentStatus;
    private String paymentMethod;

}