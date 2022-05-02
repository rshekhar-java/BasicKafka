package com.rs.basickafkaconsumer.config;

import com.fasterxml.jackson.databind.*;
import org.springframework.context.annotation.*;

/**
 * created by rs 5/1/2022.
 */
@Configuration
public class JsonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        return objectMapper;
    }
}