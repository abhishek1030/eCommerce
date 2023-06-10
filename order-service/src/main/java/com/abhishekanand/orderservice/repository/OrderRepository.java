package com.abhishekanand.orderservice.repository;

import com.abhishekanand.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
