package com.springboot.microservice_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ServiceController {

    @GetMapping("/service-1")
    public String Hello() {
        return "first-service-return";
    }
}
