package com.rs.basickafkaproducer.producer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaproducer.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;

/**
 * created by rs 4/28/2022.
 */
@Service
public class CommodityProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public void sendMessage(Commodity commodity) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(commodity);
        kafkaTemplate.send("t_commodity", commodity.getName(), json);
    }
}
