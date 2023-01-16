package com.example.springbootsecurity.controllers;

import com.example.springbootsecurity.models.Person;
import com.example.springbootsecurity.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/getPeople")
public class RestPeopleController {

    private final PeopleService peopleService;

    @Autowired
    public RestPeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> getPeopleAll() {
        return peopleService.findAll(); //Jackson сконвертON
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") int id) {
        return peopleService.findOne(id);
    }

}
