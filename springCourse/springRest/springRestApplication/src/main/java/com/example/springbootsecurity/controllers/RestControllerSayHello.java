package com.example.springbootsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerSayHello {
    @GetMapping("/sayHello")
    public String sayHello() {
        return "say hello controller";
    }
}
