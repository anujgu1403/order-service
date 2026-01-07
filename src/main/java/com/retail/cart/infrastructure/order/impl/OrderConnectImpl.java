package com.retail.checkout.infrastructure.order.impl;

import com.retail.checkout.domain.model.CartModel;
import com.retail.checkout.infrastructure.config.CartInfraProperties;
import com.retail.checkout.infrastructure.helper.OrderUtilHelper;
import com.retail.checkout.infrastructure.mapper.CartModelToOrderRequestMapper;
import com.retail.checkout.infrastructure.model.OrderRequest;
import com.retail.checkout.infrastructure.order.OrderConnector;
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
