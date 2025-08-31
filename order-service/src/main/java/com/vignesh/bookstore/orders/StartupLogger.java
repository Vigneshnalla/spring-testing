package com.vignesh.bookstore.orders;

import com.vignesh.bookstore.orders.ApplicationProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupLogger implements CommandLineRunner {

    private final ApplicationProperties properties;
    private final RabbitTemplate rabbitTemplate;

    public StartupLogger(ApplicationProperties properties, RabbitTemplate rabbitTemplate) {
        this.properties = properties;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        System.out.println("Loaded Application Properties:");
        System.out.println("Catalog Service URL: " + properties.getCatalogServiceUrl());
        System.out.println("Exchange: " + properties.getOrderEventsExchange());
        System.out.println("New Orders Queue: " + properties.getNewOrdersQueue());
        System.out.println("Delivered Orders Queue: " + properties.getDeliveredOrdersQueue());
        System.out.println("Cancelled Orders Queue: " + properties.getCancelledOrdersQueue());
        System.out.println("Error Orders Queue: " + properties.getErrorOrdersQueue());

        try {
            rabbitTemplate.convertAndSend(properties.getOrderEventsExchange(), properties.getNewOrdersQueue(), "Startup test message");
            System.out.println("✅ RabbitMQ connection successful and test message sent!");
        } catch (Exception e) {
            System.err.println("❌ RabbitMQ connection failed: " + e.getMessage());
        }
    }
}
