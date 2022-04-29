package com.rs.basickafkaproducer.producer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;

/**
 * created by rs 4/26/2022.
 */
//@Service
public class HelloKafkaProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendHello(String name){
        kafkaTemplate.send("t_hello","Hello "+ name);
    }
}
