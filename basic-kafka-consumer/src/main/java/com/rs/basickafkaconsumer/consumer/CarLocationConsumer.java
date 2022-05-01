package com.rs.basickafkaconsumer.consumer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaconsumer.entity.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/1/2022.
 */
@Service
public class CarLocationConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(CarLocationConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t-location", groupId = "cg-all-location")
    public void listenAll(String message) throws JsonMappingException, JsonProcessingException {
        var carLocation = objectMapper.readValue(message, CarLocation.class);
        LOG.info("listenAll : {}", carLocation);
    }


    @KafkaListener(topics = "t-location", groupId = "cg-far-location",containerFactory = "farLocationContainerFactory")
    public void listenFar(String message) throws JsonMappingException, JsonProcessingException {
        var carLocation = objectMapper.readValue(message, CarLocation.class);
        LOG.info("listenFar: {}", carLocation);
    }
}
