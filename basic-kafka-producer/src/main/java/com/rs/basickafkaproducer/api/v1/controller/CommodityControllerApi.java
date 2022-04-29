package com.rs.basickafkaproducer.api.v1.controller;

import com.rs.basickafkaproducer.entity.*;
import com.rs.basickafkaproducer.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * created by rs 4/28/2022.
 */
@RestController
@RequestMapping("/api/commodity/v1")
public class CommodityControllerApi {
    @Autowired
    private CommodityService commodityService;

    @GetMapping(value = "/all")
    public List<Commodity> generateCommodities() {
        return commodityService.createDummyCommodities();
    }

}
