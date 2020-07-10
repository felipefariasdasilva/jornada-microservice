package com.felipe.rental.model.form;

import com.felipe.rental.model.OrderItem;

import java.util.UUID;

public class OrderItemForm {

    private String orderId;
    private String productId;
    private String qtd;
    private String total;

    public OrderItem convert() {
        return new OrderItem(orderId, productId, qtd, total);
    }
}
