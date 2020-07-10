package com.felipe.rental.service;

import com.felipe.rental.observer.OrderItemObserver;
import com.felipe.rental.observer.OrderObserver;
import com.felipe.rental.observer.PaymentObserver;

public class Boot {
    OrderObserver orderObserver = new OrderObserver();
    OrderItemObserver orderItemObserver = new OrderItemObserver();
    PaymentObserver paymentObserver = new PaymentObserver();
}
