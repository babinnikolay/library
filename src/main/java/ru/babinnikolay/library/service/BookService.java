package ru.babinnikolay.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.babinnikolay.library.model.Book;
import ru.babinnikolay.library.model.Person;
import ru.babinnikolay.library.repository.BookRepository;

import java.util.List;


/**
 * @author Babin Nikolay
 */
@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void update(Long id, Book book) {
        bookRepository.update(id, book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAllByPersonId(Long personId) {
        return bookRepository.findAllByPersonId(personId);
    }

    public void releaseBook(Long id) {
        bookRepository.releaseById(id);
    }

    public void appointBook(Long bookId, long personId) {
        bookRepository.appointByIdAndPersonId(bookId, personId);
    }
}
