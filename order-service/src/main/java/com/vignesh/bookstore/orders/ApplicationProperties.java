package com.vignesh.bookstore.orders;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "orders")
public class ApplicationProperties {
    private String catalogServiceUrl;
    private String orderEventsExchange;
    private String newOrdersQueue;
    private String deliveredOrdersQueue;
    private String cancelledOrdersQueue;
    private String errorOrdersQueue;

    public String getCatalogServiceUrl() {
        return catalogServiceUrl;
    }

    public void setCatalogServiceUrl(String catalogServiceUrl) {
        this.catalogServiceUrl = catalogServiceUrl;
    }

    public String getOrderEventsExchange() {
        return orderEventsExchange;
    }

    public void setOrderEventsExchange(String orderEventsExchange) {
        this.orderEventsExchange = orderEventsExchange;
    }

    public String getNewOrdersQueue() {
        return newOrdersQueue;
    }

    public void setNewOrdersQueue(String newOrdersQueue) {
        this.newOrdersQueue = newOrdersQueue;
    }

    public String getDeliveredOrdersQueue() {
        return deliveredOrdersQueue;
    }

    public void setDeliveredOrdersQueue(String deliveredOrdersQueue) {
        this.deliveredOrdersQueue = deliveredOrdersQueue;
    }

    public String getCancelledOrdersQueue() {
        return cancelledOrdersQueue;
    }

    public void setCancelledOrdersQueue(String cancelledOrdersQueue) {
        this.cancelledOrdersQueue = cancelledOrdersQueue;
    }

    public String getErrorOrdersQueue() {
        return errorOrdersQueue;
    }

    public void setErrorOrdersQueue(String errorOrdersQueue) {
        this.errorOrdersQueue = errorOrdersQueue;
    }
}
