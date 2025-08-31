package com.vignesh.bookstore.orders.domain;


import org.springframework.stereotype.Component;

@Component
public class SecurityService {
    public String getLoginUserName() {
        return "vignesh";
    }
}