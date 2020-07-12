package com.felipe.consumer.controller;

import com.felipe.consumer.model.Theorder;
import com.felipe.consumer.model.dto.OrderDTO;
import com.felipe.consumer.model.form.OrderForm;
import com.felipe.consumer.repository.CustomerRepository;
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
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public List<OrderDTO> getOrders() {
        List<Theorder> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();

        for (Theorder order: orders) {
            orderDTOS.add(new OrderDTO(order));
        }

        return orderDTOS;
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrderById(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postOrders(@RequestBody OrderForm orderForm, UriComponentsBuilder uriComponentsBuilder) {
        Theorder order = orderForm.convert(customerRepository);
        orderRepository.save(order);

        URI uri = uriComponentsBuilder.path("/orders/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(new OrderDTO(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateOrders(@PathVariable String id) {
        Optional<Theorder> orderbyId = orderRepository.findById(UUID.fromString(id));
        return orderbyId.isPresent()
                ? ResponseEntity.ok(new OrderDTO(orderbyId.get()))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrders(@PathVariable String id) {
        Optional<Theorder> orderbyId = orderRepository.findById(UUID.fromString(id));

        if(orderbyId.isPresent()){
            orderRepository.delete(orderbyId.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
