package com.felipe.rental.model.form;

import com.felipe.rental.model.Order;
import com.felipe.rental.model.Payment;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentForm {

    private String orderId;
    private String paymentType;
    private String description;
    private float amount;
    private LocalDateTime paymentDate;

    private Order order;

    public Payment convert() {
        return new Payment(orderId, paymentType, description, amount, paymentDate);
    }
}
