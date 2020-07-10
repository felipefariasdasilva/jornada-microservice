package com.felipe.rental.observer;

import com.felipe.rental.model.OrderItem;

public class OrderItemObserver {

    public void created(OrderItem orderItem){
        orderItem.getOrderId().adjustTotal();
        orderItem.getOrderId().adjustBalance();
    }

    public void updated(OrderItem orderItem){
        orderItem.getOrderId().adjustTotal();
        orderItem.getOrderId().adjustBalance();
    }

    public void deleted(OrderItem orderItem){
        orderItem.getOrderId().adjustTotal();
        orderItem.getOrderId().adjustBalance();
    }
}
