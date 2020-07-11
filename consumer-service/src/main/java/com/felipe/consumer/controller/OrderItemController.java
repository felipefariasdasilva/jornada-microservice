package com.felipe.consumer.controller;

import com.felipe.consumer.model.Order;
import com.felipe.consumer.model.OrderItem;
import com.felipe.consumer.model.dto.OrderItemDTO;
import com.felipe.consumer.model.form.OrderItemForm;
import com.felipe.consumer.repository.OrderItemRepository;
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
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping
    public List<OrderItemDTO> getOrderItems(){
        List<OrderItem> orderItems = orderItemRepository.findAll();
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();

        orderItems.forEach(orderItem -> orderItemDTOS.add(new OrderItemDTO(orderItem)));

        return orderItemDTOS;
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
        Optional<OrderItem> orderItemById = orderItemRepository.findById(UUID.fromString(id));
        return orderItemById.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrderItems(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
}
