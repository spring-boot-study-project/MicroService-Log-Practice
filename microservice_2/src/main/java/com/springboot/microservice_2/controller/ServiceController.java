package com.springboot.microservice_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ServiceController {

    @GetMapping("/service-2")
    public String Hello() {
        return "second-service-return";
    }
}