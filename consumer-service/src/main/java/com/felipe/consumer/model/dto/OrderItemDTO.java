package com.felipe.consumer.model.dto;

import com.felipe.consumer.model.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {

    private String id;
    private float qtd;
    private float total;

    public OrderItemDTO(OrderItem orderItem) {

    }
}
