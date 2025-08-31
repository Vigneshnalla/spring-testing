package com.vignesh.bookstore.orders.web;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

//    @RabbitListener(queues = "${orders.new-orders-queue}")
//    public void listen(MyPayLoad message) {
//        System.out.println("Received message in new-orders-queue " + message);
//    }
//
//    @RabbitListener(queues = "${orders.delivered-orders-queue}")
//    public void listen2(MyPayLoad message) {
//        System.out.println("Received message in orders.delivered-orders-queue: " + message);
//    }
}
