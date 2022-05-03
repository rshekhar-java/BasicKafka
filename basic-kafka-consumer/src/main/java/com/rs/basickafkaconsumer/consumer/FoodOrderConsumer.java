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
public class FoodOrderConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(FoodOrderConsumer.class);

    private static final int MAX_ORDER_AMOUNT = 7;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t-food-order", errorHandler = "myFoodOrderErrorHandler")
    public void consume(String message) throws JsonMappingException, JsonProcessingException {
        var foodOrder = objectMapper.readValue(message, FoodOrder.class);
        if (foodOrder.getAmount() > MAX_ORDER_AMOUNT) {
            throw new IllegalArgumentException("Order amount is too many : " + foodOrder.getAmount());
        }

        LOG.info("Processing food order : {}", foodOrder);
    }
}
