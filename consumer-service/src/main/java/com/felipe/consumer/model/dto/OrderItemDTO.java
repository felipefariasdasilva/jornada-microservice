package com.felipe.consumer.model.dto;

import com.felipe.consumer.model.OrderItem;
import com.felipe.consumer.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderItemDTO {

    private String id;
    private float qtd;
    private float total;
    private List<ProductDTO> products;

    public OrderItemDTO(OrderItem orderItem) {
        this.id = orderItem.getId().toString();
        this.qtd = orderItem.getQtd();
        this.total = orderItem.getTotal();
        this.products = new ArrayList<>();
        this.products.addAll(orderItem.getProducts().stream().map(ProductDTO::new).collect(Collectors.toList()));
    }
}
