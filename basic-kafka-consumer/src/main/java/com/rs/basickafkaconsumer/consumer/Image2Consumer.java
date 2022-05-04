package com.rs.basickafkaconsumer.consumer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaconsumer.entity.*;
import org.apache.kafka.clients.consumer.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.annotation.*;
import org.springframework.kafka.retrytopic.*;
import org.springframework.retry.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/3/2022.
 */
//@Service
public class Image2Consumer {
    private static final Logger LOG = LoggerFactory.getLogger(Image2Consumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RetryableTopic(
            autoCreateTopics = "true", attempts = "4",
            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE,
            backoff = @Backoff(delay = 3000, maxDelay = 10_000, multiplier = 1.5, random = true),
            dltTopicSuffix = "-dead"
    )
    @KafkaListener(topics = "t-image-2", concurrency = "2")
    public void consume(ConsumerRecord<String, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
        var image = objectMapper.readValue(consumerRecord.value(), Image.class);

        if (image.getType().equalsIgnoreCase("svg")) {
            LOG.warn("Throwing exception on partition {} for image {}", consumerRecord.partition(), image);
            throw new IllegalArgumentException("Simulate API call failed");
        }

        LOG.info("Processing on partition {} for image {}", consumerRecord.partition(), image);
    }
}
