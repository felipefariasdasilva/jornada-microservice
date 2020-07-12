package com.felipe.consumer.model.dto;

import com.felipe.consumer.model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CustomerDTO {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipcode;

    private List<OrderDTO> orders;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId().toString();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.address = customer.getAddress();
        this.city = customer.getCity();
        this.state = customer.getState();
        this.zipcode = customer.getZipcode();
        this.orders = new ArrayList<>();
        this.orders.addAll(customer.getOrders().stream().map(OrderDTO::new).collect(Collectors.toList()));
    }
}
