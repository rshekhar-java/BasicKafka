package com.rs.basickafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.*;

@SpringBootApplication
@EnableScheduling
public class BasicKafkaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicKafkaConsumerApplication.class, args);
    }

}
