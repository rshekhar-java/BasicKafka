package com.rs.basickafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.*;

@SpringBootApplication
//@EnableScheduling
public class BasicKafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicKafkaProducerApplication.class, args);
    }

}
