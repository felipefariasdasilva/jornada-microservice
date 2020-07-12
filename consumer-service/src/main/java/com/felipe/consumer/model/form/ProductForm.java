package com.felipe.consumer.model.form;

import com.felipe.consumer.model.OrderItem;
import com.felipe.consumer.model.Product;
import com.felipe.consumer.model.Theorder;
import com.felipe.consumer.repository.OrderItemRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
public class ProductForm {

    private String orderItemId;
    private String name;

    public Product convert(OrderItemRepository orderItemRepository) {
        Optional<OrderItem> orderItemById = orderItemRepository.findById(UUID.fromString(orderItemId));
        if(orderItemById.isPresent()){
            return new Product(orderItemById.get(), name);
        }

        return new Product(new OrderItem(), name);
    }
}
