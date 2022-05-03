package com.rs.basickafkaconsumer.consumer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaconsumer.entity.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/2/2022.
 */
//@Service
public class SimpleNumberConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleNumberConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t-simple-number")
    public void consume(String message) throws JsonMappingException, JsonProcessingException {
        var simpleNumber = objectMapper.readValue(message, SimpleNumber.class);

        if (simpleNumber.getNumber() %2 != 0) {
            throw new IllegalArgumentException("Odd number : " + simpleNumber.getNumber());
        }

        LOG.info("Processing simpleNumber : {}", simpleNumber);
    }
}
