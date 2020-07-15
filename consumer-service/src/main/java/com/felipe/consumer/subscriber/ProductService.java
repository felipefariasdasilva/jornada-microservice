package com.felipe.consumer.subscriber;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class ProductService {

    public ProductService() {
        init();
    }

    private void init() {
        String simpleName = ProductService.class.getSimpleName();
        String topic = "PRODUCTSERVICE_NEW_PRODUCT";

        KafkaService kafkaService = new KafkaService(
                simpleName,
                topic,
                ProductService::parse
        );

        kafkaService.run();
    }

    private static void parse(ConsumerRecord consumerRecord) {
        System.out.println("-------------------------------------------");
        System.out.println("product consumed");
        System.out.println(consumerRecord.key());
        System.out.println(consumerRecord.value());
    }
}
