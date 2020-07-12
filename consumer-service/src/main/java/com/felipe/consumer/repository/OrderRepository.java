package com.felipe.consumer.repository;

import com.felipe.consumer.model.Theorder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Theorder, UUID> {
}
