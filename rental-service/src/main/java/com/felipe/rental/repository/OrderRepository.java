package com.felipe.rental.repository;

import com.felipe.rental.model.Customer;
import com.felipe.rental.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
