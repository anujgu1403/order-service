package com.retail.checkout.infrastructure.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.checkout.domain.model.CartModel;
import java.util.Objects;
import java.util.Optional;

public class OrderUtilHelper {

    public static String mapToString(CartModel cartModel){
        ObjectMapper objectMapper = new ObjectMapper();

        return Objects.requireNonNull(Optional.ofNullable(cartModel.getCartItemModels())
                .map(cartItemModels ->
                        cartItemModels.stream()
                                .map(items -> {
                                    try {
                                        return objectMapper.writeValueAsString(items);
                                    } catch (JsonProcessingException e) {
                                        throw new RuntimeException("Failed to serialize cart items", e);
                                    }
                                })).orElse(null)).toString();
    }
}
