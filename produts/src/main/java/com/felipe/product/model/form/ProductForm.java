package com.felipe.product.model.form;

import com.felipe.product.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductForm {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private float price;

    @NotNull
    private int qtdAvailable;

    @NotNull
    private int qtdTotal;

    public Product convert() {
        return new Product(name, description, price, qtdAvailable, qtdTotal);
    }

}
