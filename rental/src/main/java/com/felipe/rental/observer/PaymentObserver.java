package com.felipe.rental.observer;

import com.felipe.rental.model.Payment;

public class PaymentObserver {

    public void created(Payment payment){
        payment.getOrderId().adjustTotal();
        payment.getOrderId().adjustBalance();
    }

    public void updated(Payment payment){
        payment.getOrderId().adjustTotal();
        payment.getOrderId().adjustBalance();
    }

    public void deleted(Payment payment){
        payment.getOrderId().adjustTotal();
        payment.getOrderId().adjustBalance();
    }
}
