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
public class PaymentRequestConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentRequestConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("cachePaymentRequest")
    private Cache<PaymentRequestCacheKey, Boolean> cache;

    private boolean isExistsInCache(PaymentRequestCacheKey key) {
        return Optional.ofNullable(cache.getIfPresent(key)).orElse(false);
    }

    @KafkaListener(topics = "t-payment-request")
    public void consume(String message) throws JsonMappingException, JsonProcessingException {
        var paymentRequest = objectMapper.readValue(message, PaymentRequest.class);

        var cacheKey = new PaymentRequestCacheKey(paymentRequest.getPaymentNumber(), paymentRequest.getAmount(),
                paymentRequest.getTransactionType());
        var processed = isExistsInCache(cacheKey);

        if (processed) {
            return;
        }

        LOG.info("Processing {}", paymentRequest);

        cache.put(cacheKey, true);
    }
}
