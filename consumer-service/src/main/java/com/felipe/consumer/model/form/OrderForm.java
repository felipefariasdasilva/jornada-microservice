package com.felipe.consumer.model.form;

import com.felipe.consumer.model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderForm {

    private String customerId;
    private String status;
    private float discount;
    private float total;

    public Order convert() {
        return new Order(customerId, status, discount, total);
    }
}
