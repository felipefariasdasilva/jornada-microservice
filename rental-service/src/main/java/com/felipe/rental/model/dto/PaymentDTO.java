package com.felipe.rental.model.dto;

import com.felipe.rental.model.Order;
import com.felipe.rental.model.Payment;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentDTO {
    private String id;
    private String orderId;
    private String paymentType;
    private String description;
    private float amount;
    private LocalDateTime paymentDate;

    @ManyToOne
    private Order order;

    public PaymentDTO(Payment payment) {
        this.id = payment.getId().toString();
        this.orderId = payment.getOrder().getId().toString();
        this.paymentType = payment.getPaymentType();
        this.description = payment.getDescription();
        this.amount = payment.getAmount();
        this.paymentDate = payment.getPaymentDate();
    }
}
