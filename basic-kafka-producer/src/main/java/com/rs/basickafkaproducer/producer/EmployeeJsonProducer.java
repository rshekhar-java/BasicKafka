package com.rs.basickafkaproducer.producer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.*;
import com.rs.basickafkaproducer.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;

/**
 * created by rs 4/28/2022.
 */
@Service
public class EmployeeJsonProducer {

    @Autowired
    private KafkaTemplate<String, String > kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public void sendMessage(Employee emp) throws JsonProcessingException {

        var json = objectMapper.writeValueAsString(emp);
        kafkaTemplate.send("t_employee1",json);

    }
}
