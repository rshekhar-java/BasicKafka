package com.rs.basickafkaproducer.producer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

import java.util.concurrent.atomic.*;

/**
 * created by rs 5/3/2022.
 */
@Service
public class GeneralLedgerProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private AtomicInteger counter = new AtomicInteger();

    public void send(String message) {
        kafkaTemplate.send("t-general-ledger",message);
    }

    @Scheduled(fixedRate = 1000)
    public void schedule() {
        var message = "Ledger " + counter.incrementAndGet();
        send(message);
    }
}
