package com.rs.basickafkaconsumer.consumer;

import org.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 4/26/2022.
 */
@Service
public class FixedRateConsumer {
    private static final Logger log = LoggerFactory.getLogger(FixedRateConsumer.class);

    @KafkaListener(topics = "t_fixedrate")
    public void consume(String message) {
        log.info("Consuming : {}", message);
    }
}
