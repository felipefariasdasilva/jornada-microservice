package com.felipe.consumer.controller;

import com.felipe.consumer.model.Customer;
import com.felipe.consumer.model.Order;
import com.felipe.consumer.model.dto.CustomerDTO;
import com.felipe.consumer.model.dto.OrderDTO;
import com.felipe.consumer.model.form.OrderForm;
import com.felipe.consumer.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<OrderDTO> getOrders(){
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();

        orders.forEach(order -> orderDTOS.add(new OrderDTO(order)));

        return orderDTOS;
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrderById(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postOrders(@RequestBody OrderForm orderForm, UriComponentsBuilder uriComponentsBuilder){

        Order order = orderForm.convert();
        orderRepository.save(order);

        URI uri = uriComponentsBuilder.path("/orders/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(new OrderDTO(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateOrders(@PathVariable String id){
        Optional<Order> orderById = orderRepository.findById(UUID.fromString(id));
        return orderById.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrders(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
}
