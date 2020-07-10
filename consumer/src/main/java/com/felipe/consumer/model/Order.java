package com.felipe.consumer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private String discount;
    private String total;
    private String orderDate;

    @OneToMany(mappedBy = "order")
    private OrderItem orderItem;

    private Customer customer;
}
