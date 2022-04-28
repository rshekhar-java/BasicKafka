package com.rs.basickafkaproducer.bootstrap;

import com.rs.basickafkaproducer.producer.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
/**
 * created by rs 4/26/2022.
 */
@Component
public class ProducerLoader implements CommandLineRunner {

    @Autowired
    private KafkaKeyProducer producer;

    @Override
    public void run(String... args) throws Exception {

        for (int i =0;i< 10000;i++){
            var key="key-"+(i % 4);
            var data = "data "+i+ " With key "+key;
            producer.send(key, data);
            Thread.sleep(1000);
        }
    }

}
