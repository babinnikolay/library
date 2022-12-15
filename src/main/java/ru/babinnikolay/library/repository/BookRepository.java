package ru.babinnikolay.library.repository;

import ru.babinnikolay.library.model.Book;
import ru.babinnikolay.library.model.Person;

import java.util.List;

/**
 * @author Babin Nikolay
 */
public interface BookRepository {
    List<Book> findAll();

    Book findById(Long id);

    void save(Book book);

    void update(Long id, Book book);

    void deleteById(Long id);

    List<Book> findAllByPersonId(Long personId);
}
