package com.rs.basickafkaconsumer.consumer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.github.benmanes.caffeine.cache.*;
import com.rs.basickafkaconsumer.entity.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * created by rs 5/2/2022.
 */
@Service
public class PurchaseRequestConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(PurchaseRequestConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("cachePurchaseRequest")
    private Cache<Integer, Boolean> cache;

    private boolean isExistsInCache(int purchaseRequestId) {
        return Optional.ofNullable(cache.getIfPresent(purchaseRequestId)).orElse(false);
    }

    @KafkaListener(topics = "t-purchase-request")
    public void consume(String message) throws JsonMappingException, JsonProcessingException {
        var purchaseRequest = objectMapper.readValue(message, PurchaseRequest.class);

        var processed = isExistsInCache(purchaseRequest.getId());

        if (processed) {
            return;
        }

        LOG.info("Processing {}", purchaseRequest);

        cache.put(purchaseRequest.getId(), true);
    }
}
