package com.felipe.consumer.model.form;

import com.felipe.consumer.model.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemForm {

    private String orderId;
    private String productId;
    private String qtd;
    private String total;

    public OrderItem convert() {
        return new OrderItem();
    }
}
