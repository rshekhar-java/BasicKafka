package com.rs.basickafkaconsumer.consumer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaconsumer.entity.*;
import org.apache.kafka.clients.consumer.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/2/2022.
 */
@Service
public class ImageConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(ImageConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t-image", containerFactory = "imageRetryContainerFactory", concurrency = "2")
    public void consume(ConsumerRecord<String, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
        var image = objectMapper.readValue(consumerRecord.value(), Image.class);

        if (image.getType().equalsIgnoreCase("svg")) {
            LOG.warn("Throwing exception on partition {} for image {}", consumerRecord.partition(), image);
            throw new IllegalArgumentException("Simulate API call failed");
        }

        LOG.info("Processing on partition {} for image {}", consumerRecord.partition(), image);
    }
}
