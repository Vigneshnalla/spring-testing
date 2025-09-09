package com.vignesh.bookstore.orders.domain;

import com.vignesh.bookstore.orders.ApplicationProperties;
import com.vignesh.bookstore.orders.domain.models.OrderCancelledEvent;
import com.vignesh.bookstore.orders.domain.models.OrderCreatedEvent;
import com.vignesh.bookstore.orders.domain.models.OrderDeliveredEvent;
import com.vignesh.bookstore.orders.domain.models.OrderErrorEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final ApplicationProperties properties;

    public OrderEventPublisher(RabbitTemplate rabbitTemplate, ApplicationProperties properties) {
        this.rabbitTemplate = rabbitTemplate;
        this.properties = properties;
    }

    public void publish(OrderCreatedEvent orderEvent) {
        this.send(properties.getNewOrdersQueue(), orderEvent);
    }

    public void publish(OrderDeliveredEvent orderEvent) {
        this.send(properties.getDeliveredOrdersQueue(), orderEvent);
    }

    public void publish(OrderCancelledEvent event) {
        this.send(properties.getCancelledOrdersQueue(), event);
    }

    public void publish(OrderErrorEvent event) {
        this.send(properties.getErrorOrdersQueue(), event);
    }

    public void send(String routingKey, Object payload) {
        rabbitTemplate.convertAndSend(properties.getOrderEventsExchange(), routingKey, payload);
    }
}
