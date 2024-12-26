package com.learnspringsecurity.Spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

    @GetMapping("/home") // Public endpoint
    public String home() {
        return "Welcome to Home Controller";
    }

    @GetMapping("/request") // Should require authentication
    public String request() {
        return "Welcome to Request Controller";
    }

    @GetMapping("/login") // Optional: Spring Security typically handles login endpoints
    public String login() {
        return "Welcome to Login Controller";
    }
}
