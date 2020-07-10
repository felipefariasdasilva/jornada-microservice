package com.felipe.rental.model.dto;

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

public class OrderDTO {
    private String id;
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

    public OrderDTO(Order order) {
        this.id = order.getId().toString();
        this.customerId = order.getCustomer().getId().toString();
        this.status = order.getStatus();
        this.downpayment = order.getDownpayment();
        this.discount = order.getDiscount();
        this.deliveryFee = order.getDeliveryFee();
        this.lateFee = order.getLateFee();
        this.total = order.getTotal();
        this.balance = order.getBalance();
        this.orderDate = order.getOrderDate();
        this.returnDate = order.getReturnDate();
        this.orderItems = order.getOrderItems();
        this.customer = order.getCustomer();
        this.payments = order.getPayments();
    }
}
