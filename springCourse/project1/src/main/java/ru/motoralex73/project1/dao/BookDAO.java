package ru.motoralex73.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.motoralex73.project1.models.Book;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        System.out.println("INDEX BookDAO");
        return jdbcTemplate.query("SELECT * FROM Book",
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        System.out.println("SAVE Book");
        jdbcTemplate.update("INSERT INTO Book VALUES(?, ?, ?, ?)",
                5, book.getAutor(), book.getName(), book.getYear());
        System.out.println("SAVE BOOK EXIT");
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET autor=? name=?, year=? WHERE id=?",
                updatedBook.getAutor(), updatedBook.getName(), updatedBook.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }
}
