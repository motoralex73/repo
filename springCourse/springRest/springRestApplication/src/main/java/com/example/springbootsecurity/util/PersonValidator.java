package com.example.springbootsecurity.util;

import com.example.springbootsecurity.models.Person;
import com.example.springbootsecurity.services.PeopleService;
import com.example.springbootsecurity.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



@Component
public class PersonValidator implements Validator {

    private final PersonDetailsService peopleService;

    @Autowired
    public PersonValidator(PersonDetailsService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        try {
            peopleService.loadUserByUsername(person.getFullName());
        }
        catch (UsernameNotFoundException ignored) {
            return; //пользователь с таким именем не найден
        }
        errors.rejectValue("username","Человек с таким именем уже существует");
    }
}
