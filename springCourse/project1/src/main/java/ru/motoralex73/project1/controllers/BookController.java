package ru.motoralex73.project1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.motoralex73.project1.dao.BookDAO;
import ru.motoralex73.project1.models.Book;
import ru.motoralex73.project1.util.BookValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDAO bookDAO;
    private final BookValidator bookValidator;

    @Autowired
    public BookController(BookDAO bookDAO, BookValidator bookValidator) {
        this.bookDAO = bookDAO;
        this.bookValidator = bookValidator;
    }

    @GetMapping()
    public String index(Model model) {
        System.out.println("HELLO book");
        model.addAttribute("books", bookDAO.index());
        System.out.println("HELLO book return index");
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("books", bookDAO.show(id));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("books") Book book) {
        System.out.println("NEW Books FROM CONTROLLER");
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("books") @Valid Book book,
                         BindingResult bindingResult) {
        bookValidator.validate(book,bindingResult);

        if (bindingResult.hasErrors())
            return "books/new";

        System.out.println("CREATE Books before");
        bookDAO.save(book);
        System.out.println("CREATE Books after");
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("books", bookDAO.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("books") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        bookValidator.validate(book,bindingResult);
        if (bindingResult.hasErrors())
            return "books/edit";

        bookDAO.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }
}
