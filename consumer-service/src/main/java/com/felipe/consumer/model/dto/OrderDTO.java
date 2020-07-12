package com.felipe.consumer.model.dto;

import com.felipe.consumer.model.Theorder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private String id;
    private String status;
    private float discount;
    private float total;
    private List<OrderItemDTO> orderItemDTOS;

    public OrderDTO(Theorder theOrder) {
        this.id = theOrder.getId().toString();
        this.status = theOrder.getStatus();
        this.discount = theOrder.getDiscount();
        this.total = theOrder.getTotal();
        this.orderItemDTOS = new ArrayList<>();
        this.orderItemDTOS.addAll(theOrder.getItems().stream().map(OrderItemDTO::new).collect(Collectors.toList()));
    }
}
