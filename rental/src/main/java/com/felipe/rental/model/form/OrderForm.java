package com.felipe.rental.model.form;

import com.felipe.rental.model.Customer;
import com.felipe.rental.model.Order;
import com.felipe.rental.model.OrderItem;
import com.felipe.rental.model.Payment;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderForm {

    private String customerId;
    private String status;
    private String downpayment;
    private float discount;
    private float deliveryFee;
    private float lateFee;
    private float total;
    private float balance;
    private LocalDateTime orderDate;
    private LocalDateTime returnDate;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Customer customer;
    private List<Payment> payments = new ArrayList<>();

    public Order convert() {
        return new Order();
    }
}
