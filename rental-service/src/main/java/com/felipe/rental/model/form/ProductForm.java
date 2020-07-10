package com.felipe.rental.model.form;

import com.felipe.rental.model.Product;

import java.util.UUID;

public class ProductForm {

    private String name;
    private float price;

    public ProductForm(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public Product convert() {
        return new Product(name, price);
    }
}
