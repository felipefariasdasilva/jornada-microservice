package com.felipe.consumer.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;


    public Product(String name, String description, float price, int qtdAvailable, int qtdTotal) {
        this.name = name;
    }

    public Product(String name) {
        this.name = name;
    }
}