package com.felipe.consumer;

import com.felipe.consumer.model.Product;
import com.felipe.consumer.subscriber.KafkaService;
import com.felipe.consumer.subscriber.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
		new ProductService();
	}

}
