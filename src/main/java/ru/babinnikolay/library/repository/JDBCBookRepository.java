package ru.babinnikolay.library.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.babinnikolay.library.model.Book;
import ru.babinnikolay.library.model.BookRowMapper;
import ru.babinnikolay.library.model.Person;

import java.util.List;

/**
 * @author Babin Nikolay
 */
@Repository
@AllArgsConstructor
public class JDBCBookRepository implements BookRepository{
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT book_id, name FROM books",
                new BookRowMapper());
    }

    @Override
    public Book findById(Long id) {
        return jdbcTemplate.query("SELECT book_id, name FROM books WHERE book_id=?", new Object[]{id},
                new BookRowMapper()).stream().findAny().orElse(null);
    }

    @Override
    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO books (name) values (?)", book.getName());
    }

    @Override
    public void update(Long id, Book book) {
        jdbcTemplate.update("UPDATE books SET name=? WHERE book_id=?", book.getName(), id);
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM books WHERE book_id=?", id);
    }

    @Override
    public List<Book> findAllByPersonId(Long personId) {
        return jdbcTemplate.query("SELECT b.book_id, b.name from people as p" +
                "    join people_book pb on p.person_id = pb.person_id" +
                "    join books b on b.book_id = pb.book_id" +
                " where p.person_id=?", new Object[]{personId}, new BookRowMapper());
    }

    @Override
    public void releaseById(Long bookId) {
        jdbcTemplate.update("DELETE FROM people_book WHERE book_id=?", bookId);
    }

    @Override
    public void appointByIdAndPersonId(Long bookId, long personId) {
        jdbcTemplate.update("INSERT INTO people_book (person_id, book_id) VALUES (?, ?)", personId, bookId);
    }
}
