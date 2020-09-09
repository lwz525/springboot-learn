package com.demo.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/hello")
    public String getHello() throws InterruptedException {
        Thread.sleep(1000);
        return "hello";
    }

    @GetMapping("/annotation/anno")
    public String anno() {
        return "annotation";
    }
}
