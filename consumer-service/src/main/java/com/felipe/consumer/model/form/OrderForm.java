package com.felipe.consumer.model.form;

import com.felipe.consumer.model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderForm {

    private String customerId;
    private String status;
    private String discount;
    private String total;
    private String orderDate;

    public Order convert() {
        return new Order();
    }
}
