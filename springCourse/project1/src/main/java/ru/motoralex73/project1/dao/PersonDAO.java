package ru.motoralex73.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.motoralex73.project1.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        System.out.println("INDEX PersonDAO");
        return jdbcTemplate.query("SELECT * FROM Person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId_book(3);
        System.out.println("SAVE PEOPLE:"+person.getId_book()+","+person.getName()+","+person.getYear());
        jdbcTemplate.update("INSERT INTO Person (id_book, name, year) VALUES(?, ?, ?)",
                person.getId_book(), person.getName(), person.getYear());
        System.out.println("SAVE PEOPLE EXIT");
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, year=? WHERE id=?",
                updatedPerson.getName(), updatedPerson.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

}
