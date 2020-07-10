package com.felipe.consumer.controller;

import com.felipe.consumer.model.Order;
import com.felipe.consumer.model.Product;
import com.felipe.consumer.model.form.OrderForm;
import com.felipe.consumer.model.form.ProductForm;
import com.felipe.consumer.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity getOrders(){
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getOrderById(){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postOrders(OrderForm orderForm, UriComponentsBuilder uriComponentsBuilder){

        Order order = orderForm.convert();
        orderRepository.save(order);

        URI uri = uriComponentsBuilder.path("/orders/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity updateOrders(){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteOrders(){
        return ResponseEntity.ok().build();
    }
}
