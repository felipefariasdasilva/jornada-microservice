package com.felipe.consumer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    //private String order_Id;
    //private String product_Id;
    private float qtd;
    private float total;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;
}
