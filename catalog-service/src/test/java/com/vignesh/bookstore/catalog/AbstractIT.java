package com.vignesh.bookstore.catalog;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@Import(ContainersConfig.class)
public abstract class AbstractIT {

    // Inject the random port from Spring Boot
    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        // Assign the random port to RestAssured
        RestAssured.port = port;
    }
}
