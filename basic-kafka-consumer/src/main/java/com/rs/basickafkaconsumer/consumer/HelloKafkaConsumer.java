package com.rs.basickafkaconsumer.consumer;

import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 4/26/2022.
 */
//@Service
public class HelloKafkaConsumer {

    @KafkaListener(topics = "t_hello")
    public void consume(String message) {
        System.out.println(message);
    }
}
