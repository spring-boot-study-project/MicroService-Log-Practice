package com.springboot.microservice_1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ServiceController {
    private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

    @GetMapping("/service-1")
    public String Hello() {
        log.info("Hello World");
        return "first-service-return";
    }
}
