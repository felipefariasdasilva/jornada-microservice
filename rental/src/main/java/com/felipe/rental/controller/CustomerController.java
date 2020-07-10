package com.felipe.rental.controller;

import com.felipe.rental.model.Customer;
import com.felipe.rental.model.dto.CustomerDTO;
import com.felipe.rental.model.form.CustomerForm;
import com.felipe.rental.repository.CustomerRepository;
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
    public ResponseEntity getCustomersById(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postCustomers(@RequestBody CustomerForm customerForm, UriComponentsBuilder uriComponentsBuilder){

        Customer customer = customerForm.convert();
        customerRepository.save(customer);

        URI uri = uriComponentsBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerDTO(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCustomers(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomers(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
}
