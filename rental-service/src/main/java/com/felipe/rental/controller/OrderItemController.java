package com.felipe.rental.controller;

import com.felipe.rental.model.OrderItem;
import com.felipe.rental.model.dto.OrderItemDTO;
import com.felipe.rental.model.form.OrderItemForm;
import com.felipe.rental.repository.OrderItemRepository;
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

    @GetMapping("/{id}")
    public ResponseEntity getOrderItemsById(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postOrderItems(@RequestBody OrderItemForm orderItemForm, UriComponentsBuilder uriComponentsBuilder){

        OrderItem orderItem = orderItemForm.convert();
        orderItemRepository.save(orderItem);

        URI uri = uriComponentsBuilder.path("/order-items/{id}").buildAndExpand(orderItem.getId()).toUri();
        return ResponseEntity.created(uri).body(new OrderItemDTO(orderItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateOrderItems(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrderItems(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
}
