package com.felipe.consumer.model.form;

import com.felipe.consumer.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {

    private String name;

    public Product convert() {
        return new Product(name);
    }
}
