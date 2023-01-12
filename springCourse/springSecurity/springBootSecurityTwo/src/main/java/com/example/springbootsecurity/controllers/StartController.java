package com.example.springbootsecurity.controllers;

import com.example.springbootsecurity.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    @GetMapping()
    public String startPage() {
        return "index";
    }

    @GetMapping("/show")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello";
    }
}
