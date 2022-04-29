package com.rs.basickafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.*;
import org.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 4/28/2022.
 */
//@Service
public class KafkaKeyConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaKeyConsumer.class);

    @KafkaListener(topics = "t_multi_partitions", concurrency="4")
    public void consume(ConsumerRecord<String, String> message) throws InterruptedException {
        log.info("Key : {}, Partition : {}, Message : {}", message.key(), message.partition(), message.value());
        Thread.sleep(1000);
    }

}
