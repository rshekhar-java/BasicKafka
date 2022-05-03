package com.rs.basickafkaproducer.producer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaproducer.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/2/2022.
 */
@Service
public class SimpleNumberProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(SimpleNumber simpleNumber) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(simpleNumber);
        kafkaTemplate.send("t-simple-number", json);
    }

}
