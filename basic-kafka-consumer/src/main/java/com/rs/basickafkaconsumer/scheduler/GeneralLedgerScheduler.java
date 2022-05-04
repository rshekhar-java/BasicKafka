package com.rs.basickafkaconsumer.scheduler;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.config.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/3/2022.
 */
@Service
public class GeneralLedgerScheduler {

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    private static final Logger LOG = LoggerFactory.getLogger(GeneralLedgerScheduler.class);

    @Scheduled(cron = "0 7 7 * * ?")
    public void stop() {
        LOG.info("Stopping consumer");
        registry.getListenerContainer("general-ledger.one").pause();
    }

    @Scheduled(cron = "1 9 7 * * ?")
    public void start() {
        LOG.info("Starting consumer");
        registry.getListenerContainer("general-ledger.one").resume();
    }
}
