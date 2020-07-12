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
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String orderIdentification;
    private float qtd;
    private float total;

    @ManyToOne
    private Theorder theorder;

    @OneToMany(mappedBy = "orderItem")
    private List<Product> products = new ArrayList<>();

    public OrderItem(Theorder theOrder, float qtd, float total) {
        this.theorder = theOrder;
        this.qtd = qtd;
        this.total = total;
    }

}
