package com.felipe.consumer.controller;

import com.felipe.consumer.model.Customer;
import com.felipe.consumer.model.form.CustomerForm;
import com.felipe.consumer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity getCustomers(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postCustomers(CustomerForm customerForm, UriComponentsBuilder uriComponentsBuilder){

        Customer customer = customerForm.convert();
        customerRepository.save(customer);

        URI uri = uriComponentsBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCustomers(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteCustomers(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
}
