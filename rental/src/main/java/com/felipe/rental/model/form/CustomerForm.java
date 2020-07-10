package com.felipe.rental.model.form;

import com.felipe.rental.model.Customer;
import com.felipe.rental.model.Order;

import java.util.UUID;

public class CustomerForm {
    private String name;
    private String email;
    private String phone;

    private Order order;

    public Customer convert() {
        return new Customer(name, email, phone);
    }
}
