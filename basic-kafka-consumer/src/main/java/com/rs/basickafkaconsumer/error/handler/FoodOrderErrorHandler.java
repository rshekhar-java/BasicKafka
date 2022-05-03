package com.rs.basickafkaconsumer.error.handler;

import org.apache.kafka.clients.consumer.*;
import org.slf4j.*;
import org.springframework.kafka.listener.*;
import org.springframework.messaging.*;
import org.springframework.stereotype.*;

/**
 * created by rs 5/2/2022.
 */
@Service(value = "myFoodOrderErrorHandler")
public class FoodOrderErrorHandler implements ConsumerAwareListenerErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(FoodOrderErrorHandler.class);

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        LOG.warn("Food order error, sending to elasticsearch : {}, because : {}", message.getPayload(),
                exception.getMessage());

        if (exception.getCause() instanceof RuntimeException) {
            throw exception;
        }

        return null;
    }
}
