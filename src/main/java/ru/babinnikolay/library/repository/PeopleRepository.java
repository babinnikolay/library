package ru.babinnikolay.library.repository;

import ru.babinnikolay.library.model.Person;

import java.util.List;

/**
 * @author Babin Nikolay
 */
public interface PeopleRepository {
    List<Person> findAll();

    Person findById(Long id);

    void save(Person person);

    void update(Long id, Person person);

    void deleteById(Long id);
}
