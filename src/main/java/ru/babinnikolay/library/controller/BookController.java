package ru.babinnikolay.library.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.babinnikolay.library.model.Book;
import ru.babinnikolay.library.model.Person;
import ru.babinnikolay.library.service.BookService;
import org.springframework.ui.Model;
import ru.babinnikolay.library.service.PeopleService;

/**
 * @author Babin Nikolay
 */
@Controller
@Log4j2
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final PeopleService peopleService;

    @GetMapping
    public String books(Model model) {
        log.info("Get all books");
        model.addAttribute("books", bookService.findAll());
        return "books/books";
    }

    @GetMapping("/{id}")
    public String getBook(Model model, @PathVariable Long id) {
        log.info("Get book by id={}", id);
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("person", peopleService.findByBookId(id));
        model.addAttribute("people", peopleService.findAll());
        model.addAttribute("selected", new Person());
        return "books/book";
    }

    @GetMapping("/new")
    public String getNewForm(Model model) {
        log.info("Get form new Book");
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping
    public String create(@ModelAttribute("book") Book book) {
        log.info("Post new book={}", book);
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id) {
        log.info("Get edit form for id={}", id);
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "books/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute("book") Book book, @PathVariable Long id) {
        log.info("Edit book={}", book);
        bookService.update(id, book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable Long id) {
        log.info("Get delete form for id={}", id);
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "books/delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        log.info("Delete book id={}", id);
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @PostMapping("/{id}/release")
    public String release(@PathVariable Long id) {
        log.info("Release book id={}", id);
        bookService.releaseBook(id);
        return "redirect:/books/" + id;
    }

    @PostMapping("/{id}/appoint")
    public String appoint(@PathVariable("id") Long bookId, @ModelAttribute("selected") Person person) {
        log.info("Appoint book id={}, person={}", bookId, person);
        bookService.appointBook(bookId, person.getId());
        return "redirect:/books/" + bookId;
    }
}
