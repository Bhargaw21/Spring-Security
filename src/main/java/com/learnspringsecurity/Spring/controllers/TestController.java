package com.learnspringsecurity.Spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


    @GetMapping("/signin")
    public String signIn(){
        return "login.html";
    }
}