package com.retail.cart.infrastructure.repository;

import com.retail.cart.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}