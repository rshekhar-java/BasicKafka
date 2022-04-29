package com.rs.basickafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.*;
import org.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 4/29/2022.
 */
@Service
public class RebalanceConsumer {

    private static final Logger log = LoggerFactory.getLogger(RebalanceConsumer.class);

    @KafkaListener(topics = "t_rebalance", concurrency = "3")
    public void consume(ConsumerRecord<String, String> message) {
        log.info("Partition : {}, Offset : {}, Message : {}", message.partition(), message.offset(), message.value());
    }
}
