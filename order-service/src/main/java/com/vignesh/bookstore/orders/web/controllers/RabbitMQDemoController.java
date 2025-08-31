package com.vignesh.bookstore.orders.web.controllers;


import com.vignesh.bookstore.orders.ApplicationProperties;
import com.vignesh.bookstore.orders.web.MyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQDemoController {
    private final RabbitTemplate rabbitTemplate;
    private final ApplicationProperties applicationProperties;


    public RabbitMQDemoController(RabbitTemplate rabbitTemplate, ApplicationProperties applicationProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.applicationProperties = applicationProperties;
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody MyMessage message) {
        try {
            rabbitTemplate.convertAndSend(
                    applicationProperties.getOrderEventsExchange(),
                    message.routingKey(),
                    message.payload()
            );
            System.out.println("Message sent successfully: " + message.payload());
        } catch (Exception e) {
            System.err.println("Failed to send message: " + e.getMessage());
        }
    }

}
