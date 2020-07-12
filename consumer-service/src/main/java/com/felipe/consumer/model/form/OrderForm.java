package com.felipe.consumer.model.form;

import com.felipe.consumer.model.Customer;
import com.felipe.consumer.model.Theorder;
import com.felipe.consumer.repository.CustomerRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
public class OrderForm {

    private String customerId;
    private String status;
    private float discount;
    private float total;

    public Theorder convert(CustomerRepository customerRepository) {
        Optional<Customer> customer = customerRepository.findById(UUID.fromString(customerId));
        if(customer.isPresent()){
        return new Theorder(customer.get(), status, discount, total);
        }

        return new Theorder(new Customer(), status, discount, total);
    }
}
