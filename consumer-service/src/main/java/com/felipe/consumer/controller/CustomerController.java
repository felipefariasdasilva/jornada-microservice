package com.felipe.consumer.controller;

import com.felipe.consumer.model.Customer;
import com.felipe.consumer.model.dto.CustomerDTO;
import com.felipe.consumer.model.form.CustomerForm;
import com.felipe.consumer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<CustomerDTO> getCustomers(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer: customers) {
            customerDTOS.add(new CustomerDTO(customer));
        }
        return customerDTOS;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postCustomers(@RequestBody CustomerForm customerForm, UriComponentsBuilder uriComponentsBuilder){
        System.out.println(customerForm.toString());
        Customer customer = customerForm.convert();
        customerRepository.save(customer);

        URI uri = uriComponentsBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerDTO(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCustomers(@PathVariable String id){
        Optional<Customer> byId = customerRepository.findById(id);
        if(byId.isPresent()){
            System.out.println("achei");
            return ResponseEntity.ok().build();
        }else{
            System.out.println("nao achei");
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping
    public ResponseEntity deleteCustomers(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
}
