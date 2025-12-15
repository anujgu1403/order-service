package com.retail.checkout.infrastructure.repository;

import com.retail.checkout.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}