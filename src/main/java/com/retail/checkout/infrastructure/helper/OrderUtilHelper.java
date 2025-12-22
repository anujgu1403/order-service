package com.retail.checkout.infrastructure.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.checkout.domain.model.CartItemModel;
import com.retail.checkout.domain.model.CartModel;
import com.retail.checkout.infrastructure.model.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class OrderUtilHelper {

    private final ObjectMapper objectMapper;

    public String mapToString(CartModel cartModel){
        try {
            return objectMapper.writeValueAsString(cartModel.getCartItemModels());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize cart items", e);
        }
    }

    public List<CartItemModel> mapToCartItems(String json) {
        try {
            return objectMapper.readValue(
                    json,
                    new TypeReference<List<CartItemModel>>() {}
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize cart items", e);
        }
    }

    public String mapOrderToString(OrderRequest orderRequest){
        try {
            return objectMapper.writeValueAsString(orderRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize order request", e);
        }
    }
}
