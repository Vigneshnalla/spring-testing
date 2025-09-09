package com.vignesh.bookstore.orders;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class RetryTestService {

    @Retry(name = "catalogServiceRetry")
    public void alwaysFail() {
        System.out.println("Trying...");
        throw new org.springframework.web.client.ResourceAccessException("Simulated timeout");
    }
}
