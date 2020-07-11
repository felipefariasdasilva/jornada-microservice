package com.felipe.consumer.model.form;

import com.felipe.consumer.model.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerForm {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipcode;

    public Customer convert() {
        return new Customer(name, email, phone, address, city, state, zipcode);
    }
}
