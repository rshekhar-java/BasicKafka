package com.rs.basickafkaconsumer.consumer;

import org.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/3/2022.
 */
@Service
public class GeneralLedgerConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(GeneralLedgerConsumer.class);

    @KafkaListener(id = "general-ledger.one", topics = "t-general-ledger")
    public void consumeOne(String message) {
        LOG.info("From consumerOne : {}",message);
    }

    @KafkaListener(topics = "t-general-ledger")
    public void consumeTwo(String message) {
        LOG.info("From consumerTwo : {}",message);
    }
}
