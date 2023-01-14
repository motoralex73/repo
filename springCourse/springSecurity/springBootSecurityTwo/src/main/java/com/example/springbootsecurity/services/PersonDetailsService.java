package com.example.springbootsecurity.services;

import com.example.springbootsecurity.models.Person;
import com.example.springbootsecurity.repositories.PeopleRepository;
import com.example.springbootsecurity.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class PersonDetailsService  implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String fullName) throws UsernameNotFoundException {
        Optional<Person> personOption = peopleRepository.findByFullName(fullName);
        if (personOption.isEmpty()) throw new UsernameNotFoundException("User not found!");
        return new PersonDetails(personOption.get());
    }
}
