package com.rs.basickafkaconsumer.consumer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaconsumer.entity.*;
import org.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

/**
 * created by rs 4/29/2022.
 */
@Service
public class CommodityNotificationConsumer {

    private ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    private static final Logger log = LoggerFactory.getLogger(CommodityNotificationConsumer.class);

    @KafkaListener(topics = "t_commodity", groupId = "cg-notification")
    public void consume(String message) throws JsonParseException, JsonMappingException, IOException {
        var commodity = objectMapper.readValue(message, Commodity.class);
        log.info("Notification logic for {}", commodity);
    }
}
