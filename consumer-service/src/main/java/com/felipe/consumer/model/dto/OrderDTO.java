package com.felipe.consumer.model.dto;

import com.felipe.consumer.model.Order;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderDTO {

    private String id;
    private String status;
    private float discount;
    private float total;
    private String orderDate;
    private List<OrderItemDTO> orderItems;

    public OrderDTO(Order order) {
        this.id = order.getId().toString();
        this.status = order.getStatus();
        this.discount = order.getDiscount();
        this.total = order.getTotal();
        this.orderDate = order.getOrderDate().toString();
        this.orderItems = new ArrayList<>();
        this.orderItems.addAll(order.getOrderItems().stream().map(OrderItemDTO::new).collect(Collectors.toList()));
    }
}
