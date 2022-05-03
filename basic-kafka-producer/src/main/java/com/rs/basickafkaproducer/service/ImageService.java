package com.rs.basickafkaproducer.service;

import com.rs.basickafkaproducer.entity.*;
import org.springframework.stereotype.*;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**
 * created by rs 5/2/2022.
 */
@Service
public class ImageService {
    private static AtomicInteger counter = new AtomicInteger();

    public Image generateImage(String type) {
        var name = "image-" + counter.incrementAndGet();
        var size = ThreadLocalRandom.current().nextLong(100, 10_000);

        return new Image(name, size, type);
    }
}
