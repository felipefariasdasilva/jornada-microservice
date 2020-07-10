package com.felipe.rental.observer;

import com.felipe.rental.model.Payment;

public class PaymentObserver {

    public void created(Payment payment){
        payment.getOrder().adjustTotal();
        payment.getOrder().adjustBalance();
    }

    public void updated(Payment payment){
        payment.getOrder().adjustTotal();
        payment.getOrder().adjustBalance();
    }

    public void deleted(Payment payment){
        payment.getOrder().adjustTotal();
        payment.getOrder().adjustBalance();
    }
}
