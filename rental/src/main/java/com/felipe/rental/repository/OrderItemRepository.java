package com.felipe.rental.repository;

import com.felipe.rental.model.Customer;
import com.felipe.rental.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
}
