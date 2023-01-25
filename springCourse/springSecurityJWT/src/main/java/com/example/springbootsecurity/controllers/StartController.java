package com.example.springbootsecurity.controllers;

import com.example.springbootsecurity.security.PersonDetails;
import com.example.springbootsecurity.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StartController {
    private final AdminService adminService;

    @Autowired
    public StartController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping()
    public String startPage() {
        return "index";
    }

    @GetMapping("/show")
    @ResponseBody
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        return personDetails.getUsername();
    }

    @GetMapping("/admin")
    public String adminPage() {
        adminService.doAdminStuff();

        return "admin";
    }
}
