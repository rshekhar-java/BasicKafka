package com.rs.basickafkaproducer.service;

import com.rs.basickafkaproducer.entity.*;
import org.springframework.stereotype.*;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**
 * created by rs 5/3/2022.
 */
@Service
public class InvoiceService {
    private AtomicInteger counter = new AtomicInteger();

    public Invoice generateInvoice() {
        var invoiceNumber = "INV-" + counter.incrementAndGet();
        var amount = ThreadLocalRandom.current().nextInt(1, 1000);

        return new Invoice(invoiceNumber, amount, "USD");
    }

}
