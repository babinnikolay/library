package ru.babinnikolay.library.repository;

import org.springframework.stereotype.Component;
import ru.babinnikolay.library.model.Person;

import java.util.Collection;
import java.util.List;

/**
 * @author Babin Nikolay
 */
public interface Repository {
    List<Person> findAll();

    Person findById(Long id);

    void save(Person person);
}
