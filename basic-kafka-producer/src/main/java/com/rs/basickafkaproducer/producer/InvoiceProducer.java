package com.rs.basickafkaproducer.producer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaproducer.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/3/2022.
 */
@Service
public class InvoiceProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(Invoice invoice) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(invoice);
        kafkaTemplate.send("t-invoice", invoice.getAmount() % 2, invoice.getInvoiceNumber(), json);
    }

}
