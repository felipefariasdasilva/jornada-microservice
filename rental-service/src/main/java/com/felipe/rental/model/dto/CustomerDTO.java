package com.felipe.rental.model.dto;

import com.felipe.rental.model.Customer;
import com.felipe.rental.model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private String id;
    private String name;
    private String email;
    private String phone;

    private Order order;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId().toString();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
    }
}
