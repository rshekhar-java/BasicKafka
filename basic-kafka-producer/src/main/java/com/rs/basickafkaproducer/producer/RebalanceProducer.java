package com.rs.basickafkaproducer.producer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 4/29/2022.
 */
@Service
public class RebalanceProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private int i = 0;

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        i++;
        kafkaTemplate.send("t_rebalance", "Counter is " + i);
    }
}
