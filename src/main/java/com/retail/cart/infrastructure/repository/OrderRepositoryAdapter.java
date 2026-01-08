package com.retail.cart.infrastructure.repository;

import com.retail.cart.domain.model.CartModel;
import com.retail.cart.infrastructure.entity.OrderEntity;
import com.retail.cart.infrastructure.mapper.OrderEntityToCartModelMapper;
import com.retail.cart.infrastructure.mapper.CartModelToOrderEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
@Transactional
public class OrderRepositoryAdapter implements OrderRepository {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Autowired
    OrderEntityToCartModelMapper orderEntityToCartModelMapper;

    @Autowired
    CartModelToOrderEntityMapper cartModelToOrderEntityMapper;

    @Override
    public CartModel submitOrder(CartModel cartModel) {
        OrderEntity orderEntity = cartModelToOrderEntityMapper.apply(cartModel);
        orderEntity.setStatus("Submitted");
        return orderEntityToCartModelMapper.apply(orderJpaRepository.save(orderEntity));
    }
}