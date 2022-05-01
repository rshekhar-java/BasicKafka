package com.rs.basickafkaproducer.scheduler;

import com.fasterxml.jackson.core.*;
import com.rs.basickafkaproducer.entity.*;
import com.rs.basickafkaproducer.producer.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.*;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.util.*;

/**
 * created by rs 4/28/2022.
 */
//@Service
public class CommodityScheduler {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CommodityProducer producer;

    @Scheduled(fixedRate = 5000)
    public void fetchCommodities() {
        var commodities = restTemplate.exchange("http://localhost:8118/api/commodity/v1/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Commodity>>() {
                }).getBody();

        commodities.forEach(c -> {
            try {
                producer.sendMessage(c);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }

}
