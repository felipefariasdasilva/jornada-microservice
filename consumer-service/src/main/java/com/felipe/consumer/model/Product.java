package com.felipe.consumer.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String orderItemIdentification;
    private String name;

    @ManyToOne
    private OrderItem orderItem;

    public Product(String name) {
        this.name = name;
    }

    public Product(OrderItem orderItem, String name) {
        this.orderItem = orderItem;
        this.name = name;
    }
}