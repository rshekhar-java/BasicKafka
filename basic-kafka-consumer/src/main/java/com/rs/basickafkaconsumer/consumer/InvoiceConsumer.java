package com.rs.basickafkaconsumer.consumer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaconsumer.entity.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/3/2022.
 */
//@Service
public class InvoiceConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t-invoice", concurrency = "2", containerFactory = "invoiceDltContainerFactory")
    public void consume(String message) throws JsonMappingException, JsonProcessingException {
        var invoice = objectMapper.readValue(message, Invoice.class);

        if (invoice.getAmount() < 100000) {
            throw new IllegalArgumentException("Invalid amount for " + invoice);
        }

        LOG.info("Processing invoice : {}", invoice);
    }
}
