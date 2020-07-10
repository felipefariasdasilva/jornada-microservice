package com.felipe.rental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String customerId;
    private String status;
    private String downpayment;
    private float discount;
    private float deliveryFee;
    private float lateFee;
    private float total;
    private float balance;
    private LocalDateTime orderDate;
    private LocalDateTime returnDate;

    @OneToMany
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Payment> payments = new ArrayList<>();
}
