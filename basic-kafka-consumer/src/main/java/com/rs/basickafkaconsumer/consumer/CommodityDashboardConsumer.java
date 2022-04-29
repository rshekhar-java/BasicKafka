package com.rs.basickafkaconsumer.consumer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaconsumer.entity.*;
import org.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.concurrent.*;

/**
 * created by rs 4/29/2022.
 */
@Service
public class CommodityDashboardConsumer {

    private ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    private static final Logger log = LoggerFactory.getLogger(CommodityDashboardConsumer.class);

    @KafkaListener(topics = "t_commodity", groupId = "cg-dashboard")
    public void consume(String message)
            throws JsonParseException, JsonMappingException, IOException, InterruptedException {
        var commodity = objectMapper.readValue(message, Commodity.class);

        Thread.sleep(ThreadLocalRandom.current().nextLong(500, 1000));

        log.info("Dashboard logic for {}", commodity);
    }
}
