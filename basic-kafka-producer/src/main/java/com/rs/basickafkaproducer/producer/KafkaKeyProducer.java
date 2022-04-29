package com.rs.basickafkaproducer.producer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;

/**
 * created by rs 4/28/2022.
 */
//@Service
public class KafkaKeyProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String key, String data){
        kafkaTemplate.send("t_multi_partitions",key, data);
    }

}
