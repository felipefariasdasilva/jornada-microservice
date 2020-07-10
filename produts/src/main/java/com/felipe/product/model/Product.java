package com.felipe.product.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private float price;
    private int qtdAvailable;
    private int qtdTotal;

    public Product(String name, String description, float price, int qtdAvailable, int qtdTotal) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.qtdAvailable = qtdAvailable;
        this.qtdTotal = qtdTotal;
    }
}
