package com.rs.basickafkaconsumer.config;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.rs.basickafkaconsumer.entity.*;
import com.rs.basickafkaconsumer.error.handler.*;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.kafka.*;
import org.springframework.context.annotation.*;
import org.springframework.kafka.config.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.*;
import org.springframework.kafka.listener.adapter.*;
import org.springframework.util.backoff.*;

/**
 * created by rs 4/29/2022.
 */
@Configuration
public class KafkaConfig {

    @Autowired
    private KafkaProperties kafkaProperties;
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public ConsumerFactory<Object, Object> consumerFactory() {
        var properties = kafkaProperties.buildConsumerProperties();

        properties.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, "120000");

        return new DefaultKafkaConsumerFactory<Object, Object>(properties);
    }

    @Bean(name = "farLocationContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<Object, Object> farLocationContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
        var factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
        configurer.configure(factory, consumerFactory());

        factory.setRecordFilterStrategy(new RecordFilterStrategy<Object, Object>() {

            @Override
            public boolean filter(ConsumerRecord<Object, Object> consumerRecord) {
                try {
                    CarLocation carLocation = objectMapper.readValue(consumerRecord.value().toString(),
                            CarLocation.class);
                    return carLocation.getDistance() <= 100;
                } catch (JsonProcessingException e) {
                    return false;
                }
            }
        });

        return factory;
    }

	@Bean(name = "kafkaListenerContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<Object, Object> kafkaListenerContainerFactory(
			ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
		var factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
		configurer.configure(factory, consumerFactory());

		factory.setCommonErrorHandler(new GlobalErrorHandler());

		return factory;
	}

    @Bean(name = "imageRetryContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<Object, Object> imageRetryContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
        var factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
        configurer.configure(factory, consumerFactory());

        factory.setCommonErrorHandler(new DefaultErrorHandler(new FixedBackOff(10_000, 3)));

        return factory;
    }

    @Bean(name = "invoiceDltContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<Object, Object> invoiceDltContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer, KafkaTemplate<String, String> kafkaTemplate) {
        var factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
        configurer.configure(factory, consumerFactory());

        var recoverer = new DeadLetterPublishingRecoverer(kafkaTemplate,
                (record, ex)-> new TopicPartition("t-invoice-dead",record.partition()));

        factory.setCommonErrorHandler(new DefaultErrorHandler(recoverer, new FixedBackOff(3000, 5)));

        return factory;
    }

}
