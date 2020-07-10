package com.felipe.rental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Order orderId;
    private String paymentType;
    private String description;
    private float amount;
    private LocalDateTime paymentDate;

    @ManyToOne
    private Order order;

    public Payment(String orderId, String paymentType, String description, float amount, LocalDateTime paymentDate) {

    }
}
