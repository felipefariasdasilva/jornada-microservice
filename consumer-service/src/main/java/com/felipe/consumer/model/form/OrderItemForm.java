package com.felipe.consumer.model.form;

import com.felipe.consumer.model.OrderItem;
import com.felipe.consumer.model.Theorder;
import com.felipe.consumer.repository.OrderRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
public class OrderItemForm {

    private String orderId;
    private float qtd;
    private float total;

    public OrderItem convert(OrderRepository orderRepository) {
        Optional<Theorder> order = orderRepository.findById(UUID.fromString(orderId));
        if(order.isPresent()){
            return new OrderItem(order.get(), qtd, total);
        }

        return new OrderItem(new Theorder(), qtd, total);
    }
}
