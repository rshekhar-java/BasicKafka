package com.rs.basickafkaproducer.producer;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 4/26/2022.
 */
@Service
public class FixedRateProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private int i = 0;

    private Logger log = LoggerFactory.getLogger(FixedRateProducer.class);

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        i++;
        log.info("i is " + i);
        kafkaTemplate.send("t_fixedrate_2", "Fixed rate " + i);
    }
}
