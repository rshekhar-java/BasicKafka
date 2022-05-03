package com.rs.basickafkaconsumer.error.handler;

import org.apache.kafka.clients.consumer.*;
import org.slf4j.*;
import org.springframework.kafka.listener.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/2/2022.
 */
@Component
public class GlobalErrorHandler implements CommonErrorHandler{

    private static final Logger LOG = LoggerFactory.getLogger(GlobalErrorHandler.class);

    @Override
    public void handleOtherException(Exception thrownException, Consumer<?, ?> consumer,
                                     MessageListenerContainer container, boolean batchListener) {
        LOG.warn("Handling other exception : {}", thrownException.getMessage());
    }

    @Override
    public void handleRecord(Exception thrownException, ConsumerRecord<?, ?> record, Consumer<?, ?> consumer,
                             MessageListenerContainer container) {
        LOG.warn("Handling exception for record : {}, because : {}", record.value(), thrownException.getMessage());
    }
}
