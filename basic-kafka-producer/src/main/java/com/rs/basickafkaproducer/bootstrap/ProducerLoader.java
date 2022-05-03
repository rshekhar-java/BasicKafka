package com.rs.basickafkaproducer.bootstrap;

import com.rs.basickafkaproducer.entity.*;
import com.rs.basickafkaproducer.producer.*;
import com.rs.basickafkaproducer.service.*;
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

    //employee
/*    @Autowired
    private EmployeeJsonProducer producer;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            var employee = new Employee("emp-" + i, "Employee " + i, LocalDate.now());
            producer.sendMessage(employee);
        }
    }*/

    //purchase request
/*    @Autowired
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

    }*/

/*    //payment request bootstrap
    @Autowired
    PaymentRequestProducer paymentProducer;

    @Override
    public void run(String... args) throws Exception {
        var paymentRequestAlpha_Transaction1 = new PaymentRequest("Pay-Alpha",551,"USD","Notes Aplha", "Budget reserve");
        var paymentRequestAlpha_Transaction2 = new PaymentRequest("Pay-Alpha",551,"USD","Notes Aplha", "Approval Workflow");
        var paymentRequestAlpha_Transaction3 = new PaymentRequest("Pay-Alpha",551,"USD","Notes Aplha", "Push Notification");

        var paymentRequestBeta_Transaction1 = new PaymentRequest("Pay-Beta",552,"USD","Notes Beta", "Budget reserve");
        var paymentRequestBeta_Transaction2 = new PaymentRequest("Pay-Beta",552,"USD","Notes Beta", "Approval Workflow");
        var paymentRequestBeta_Transaction3 = new PaymentRequest("Pay-Beta",552,"USD","Notes Beta", "Push Notification");

        paymentProducer.send(paymentRequestAlpha_Transaction1);
        paymentProducer.send(paymentRequestAlpha_Transaction2);
        paymentProducer.send(paymentRequestAlpha_Transaction3);
        paymentProducer.send(paymentRequestBeta_Transaction1);
        paymentProducer.send(paymentRequestBeta_Transaction2);
        paymentProducer.send(paymentRequestBeta_Transaction3);

        paymentProducer.send(paymentRequestAlpha_Transaction2);
        paymentProducer.send(paymentRequestBeta_Transaction3);


    }*/

/*
    //food-order
    @Autowired
    private FoodOrderProducer foodOrderProducer;

    //Simple Number
    @Autowired
    private SimpleNumberProducer simpleNumberProducer;

    @Override
    public void run(String... args) throws Exception {
        var cheeseOrder = new FoodOrder(3,"Cheese");
        var biryaniOrder = new FoodOrder(10,"Veg Biryani");
        var choclateOrder = new FoodOrder(5,"Choclate");

        foodOrderProducer.send(cheeseOrder);
        foodOrderProducer.send(biryaniOrder);
        foodOrderProducer.send(choclateOrder);

        for (int i = 100;i < 103;i++){
            var simpleNumber = new SimpleNumber(i);
            simpleNumberProducer.send(simpleNumber);
        }

    }
*/

/*
    //image
    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageProducer producer;

    @Override
    public void run(String... args) throws Exception {

        var image1 = imageService.generateImage("jpg");
        var image2 = imageService.generateImage("svg");
        var image3 = imageService.generateImage("png");
        var image4 = imageService.generateImage("gif");
        var image5 = imageService.generateImage("bmp");
        var image6 = imageService.generateImage("tiff");

        producer.send(image1,0);
        producer.send(image2,0);
        producer.send(image3,0);
        producer.send(image4,1);
        producer.send(image5,1);
        producer.send(image6,1);
    }
*/

    //invoice
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceProducer producer;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            var invoice = invoiceService.generateInvoice();
            if(i > 5){
                invoice.setAmount(0);
            }
            producer.send(invoice);
        }
        }

    }
