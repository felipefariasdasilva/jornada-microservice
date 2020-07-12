package com.felipe.consumer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Theorder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String customerIdentification;
    private String status;
    private float discount;
    private float total;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "theorder")
    private List<OrderItem> items = new ArrayList<>();

    public Theorder(Customer customer, String status, float discount, float total) {
        this.customer = customer;
        this.status = status;
        this.discount = discount;
        this.total = total;
    }
}
