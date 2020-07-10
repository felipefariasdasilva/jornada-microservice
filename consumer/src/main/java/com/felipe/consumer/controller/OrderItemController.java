package com.felipe.consumer.controller;

import com.felipe.consumer.model.OrderItem;
import com.felipe.consumer.model.form.OrderItemForm;
import com.felipe.consumer.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping
    public ResponseEntity getOrderItems(){
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getOrderItemsById(){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postOrderItems(OrderItemForm orderItemForm, UriComponentsBuilder uriComponentsBuilder){

        OrderItem orderItem = orderItemForm.convert();
        orderItemRepository.save(orderItem);

        URI uri = uriComponentsBuilder.path("/order-items/{id}").buildAndExpand(orderItem.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity updateOrderItems(){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteOrderItems(){
        return ResponseEntity.ok().build();
    }
}
