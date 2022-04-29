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

    @Autowired
    private EmployeeJsonProducer producer;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            var employee = new Employee("emp-" + i, "Employee " + i, LocalDate.now());
            producer.sendMessage(employee);
        }
    }

}
