package com.felipe.consumer.model;

import com.felipe.consumer.repository.CustomerRepository;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String idOfcustomer;
    private String status;
    private float discount;
    private float total;
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    private Customer customer;

    public Order(String customerId, String status, float discount, float total) {
        this.idOfcustomer = customerId;
        this.status = status;
        this.discount = discount;
        this.total = total;
        this.orderDate = LocalDateTime.now();
        //this.customer = new Customer();
    }
}
