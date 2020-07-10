package com.felipe.rental.observer;

import com.felipe.rental.model.Order;

public class OrderObserver {

    public void created(Order order){
        order.adjustTotal();
    }

    public void updated(Order order){
        order.adjustTotal();
        order.adjustBalance();
    }
}
