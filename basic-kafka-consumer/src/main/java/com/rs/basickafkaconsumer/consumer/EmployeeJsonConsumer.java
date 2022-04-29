package com.rs.basickafkaconsumer.consumer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaconsumer.entity.*;
import org.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

/**
 * created by rs 4/28/2022.
 */
@Service
public class EmployeeJsonConsumer {

    private ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    private static final Logger log = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

    @KafkaListener(topics = "t_employee1")
    public void consume(String message) throws JsonParseException, JsonMappingException, IOException {
        var emp = objectMapper.readValue(message, Employee.class);
        log.info("Employee is {}", emp);
    }

}
