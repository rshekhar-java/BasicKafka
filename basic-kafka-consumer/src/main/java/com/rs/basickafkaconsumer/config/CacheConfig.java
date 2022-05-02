package com.rs.basickafkaconsumer.config;

import com.github.benmanes.caffeine.cache.*;
import com.rs.basickafkaconsumer.consumer.*;
import org.springframework.context.annotation.*;

import java.time.*;


/**
 * created by rs 5/2/2022.
 */
@Configuration
public class CacheConfig {

    @Bean(name = "cachePurchaseRequest")
    public Cache<Integer, Boolean> cachePurchaseRequest() {
        return Caffeine.newBuilder().expireAfterWrite(Duration.ofMinutes(2)).maximumSize(1000).build();
    }

    @Bean(name = "cachePaymentRequest")
    public Cache<PaymentRequestCacheKey, Boolean> cachePaymentRequest() {
        return Caffeine.newBuilder().expireAfterWrite(Duration.ofMinutes(2)).maximumSize(1000).build();
    }
}
