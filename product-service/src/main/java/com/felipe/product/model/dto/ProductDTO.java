package com.felipe.product.model.dto;

import com.felipe.product.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private float price;
    private int qtdAvailable;
    private int qtdTotal;

    public ProductDTO(Product product) {
        this.id = product.getId().toString();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.qtdAvailable = product.getQtdAvailable();
        this.qtdTotal = product.getQtdTotal();
    }

}
