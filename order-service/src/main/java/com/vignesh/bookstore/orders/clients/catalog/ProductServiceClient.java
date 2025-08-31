package com.vignesh.bookstore.orders.clients.catalog;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Component
public class ProductServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceClient.class);

    private final RestClient restClient;

    public ProductServiceClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public Optional<Product> getProductByCode(String productCode) {
        logger.info("fetching product for code: {}", productCode);

        try {
            Product product = restClient.get()
                    .uri("/api/products/{code}", productCode)
                    .retrieve()
                    .body(Product.class);
            return Optional.ofNullable(product);
        } catch (Exception e) {
            logger.error("Error fetching product with code {}: {}", productCode, e.getMessage());
            return Optional.empty();
        }
    }
}
