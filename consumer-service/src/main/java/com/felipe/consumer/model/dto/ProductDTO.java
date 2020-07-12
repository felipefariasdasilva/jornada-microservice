package com.felipe.consumer.model.dto;

import com.felipe.consumer.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private String id;
    private String name;

    public ProductDTO(Product product) {
        this.id = product.getId().toString();
        this.name = product.getName();
    }
}
