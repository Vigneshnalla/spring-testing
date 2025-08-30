package com.vignesh.bookstore.catalog.web.controllers;

import com.vignesh.bookstore.catalog.domain.PagedResult;
import com.vignesh.bookstore.catalog.domain.Product;
import com.vignesh.bookstore.catalog.domain.ProductNotFoundException;
import com.vignesh.bookstore.catalog.domain.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    ResponseEntity<Product> getProducts(@PathVariable String code) {
        return productService
                .getProductByCode(code)
                .map(ResponseEntity::ok) // 200 + product
                .orElseThrow(() -> ProductNotFoundException.forCode(code)); // 404
    }

    @GetMapping("/health-check")
    String healthCheck() {
        return "Catalog Service is up and running";
    }
}
