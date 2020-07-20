package com.felipe.consumer.subscriber;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class ProductService {

    public ProductService() {
        String simpleName = ProductService.class.getSimpleName();
        String topic = "PRODUCTSERVICE_NEW_PRODUCT";

        KafkaService kafkaService = new KafkaService(
                simpleName,
                topic,
                ProductService::parse
        );

        kafkaService.run();
    }

    public static void parse(ConsumerRecord consumerRecord) {
        System.out.println("-------------------------------------------");
        System.out.println("product consumed");
        System.out.println(consumerRecord.key());
        System.out.println(consumerRecord.value());
    }
}
