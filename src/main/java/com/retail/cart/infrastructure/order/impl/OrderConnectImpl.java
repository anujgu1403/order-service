package com.retail.cart.infrastructure.order.impl;

import com.retail.cart.domain.model.CartModel;
import com.retail.cart.infrastructure.config.CartInfraProperties;
import com.retail.cart.infrastructure.helper.OrderUtilHelper;
import com.retail.cart.infrastructure.mapper.CartModelToOrderRequestMapper;
import com.retail.cart.infrastructure.model.OrderRequest;
import com.retail.cart.infrastructure.order.OrderConnector;
import com.retail.core.kafka.producer.KafkaMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderConnectImpl implements OrderConnector {

    @Autowired
    private CartModelToOrderRequestMapper cartModelToOrderRequestMapper;

    @Autowired
    private CartInfraProperties cartInfraProperties;

    private final KafkaMessageProducer kafkaMessageProducer;

    @Autowired
    private OrderUtilHelper orderUtilHelper;


    @Override
    public CartModel pushOrderToKafka(CartModel cartModel) {
        OrderRequest orderRequest = cartModelToOrderRequestMapper.apply(cartModel);
        String orderString = orderUtilHelper.mapOrderToString(orderRequest);
        kafkaMessageProducer.send(cartInfraProperties.getOrderCaptureTopic(), String.valueOf(orderRequest.getOrderId()), orderString);
        return cartModel;
    }
}
