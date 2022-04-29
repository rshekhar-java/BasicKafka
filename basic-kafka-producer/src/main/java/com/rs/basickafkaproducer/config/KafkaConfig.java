package com.rs.basickafkaproducer.config;

import org.apache.kafka.clients.producer.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.kafka.*;
import org.springframework.context.annotation.*;
import org.springframework.kafka.core.*;

/**
 * created by rs 4/29/2022.
 */
@Configuration
public class KafkaConfig {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        var properties = kafkaProperties.buildProducerProperties();

        properties.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, "180000");

        return new DefaultKafkaProducerFactory<String, String>(properties);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }
}
