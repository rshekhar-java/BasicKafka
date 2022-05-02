package com.rs.basickafkaproducer.bootstrap;

import com.rs.basickafkaproducer.entity.*;
import com.rs.basickafkaproducer.producer.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.sql.*;
import java.time.*;

/**
 * created by rs 4/26/2022.
 */
@Component
public class ProducerLoader implements CommandLineRunner {

/*    @Autowired
    private EmployeeJsonProducer producer;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            var employee = new Employee("emp-" + i, "Employee " + i, LocalDate.now());
            producer.sendMessage(employee);
        }
    }*/

    @Autowired
    private PurchaseRequestProducer producerPurchase;

    @Override
    public void run(String... args) throws Exception {

        var pr1 = new PurchaseRequest(5551,"PR-First",991,"USD");
        var pr2 = new PurchaseRequest(5552,"PR-Seconf",992,"USD");
        var pr3 = new PurchaseRequest(5553,"PR-Third",993,"USD");
        var pr4 = new PurchaseRequest(5554,"PR-Fourth",994,"USD");

        producerPurchase.send(pr1);
        producerPurchase.send(pr2);
        producerPurchase.send(pr3);
        producerPurchase.send(pr4);

        producerPurchase.send(pr1);

    }
}
