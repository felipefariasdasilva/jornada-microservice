package com.felipe.rental.model.dto;

import com.felipe.rental.model.OrderItem;

import java.util.UUID;

public class OrderItemDTO {
    private String id;
    private String orderId;
    private String productId;
    private String qtd;
    private String total;

    public OrderItemDTO(OrderItem orderItem) {
        this.id = orderItem.getId().toString();
        this.orderId = orderItem.getOrderId().getId().toString();
        this.productId = orderItem.getProductId().getId().toString();
        this.qtd = orderItem.getQtd();
        this.total = orderItem.getTotal();
    }
}
