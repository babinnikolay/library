package ru.babinnikolay.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.babinnikolay.library.model.Person;
import ru.babinnikolay.library.repository.PeopleRepository;

import java.util.List;

/**
 * @author Babin Nikolay
 */
@Service
@AllArgsConstructor
public class PeopleService {
    private final PeopleRepository peopleRepository;
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findById(Long id) {
        return peopleRepository.findById(id);
    }

    public void save(Person person) {
        peopleRepository.save(person);
    }

    public void update(Long id, Person person) {
        peopleRepository.update(id, person);
    }

    public void deleteById(Long id) {
        peopleRepository.deleteById(id);
    }

    public Person findByBookId(Long bookId) {
        return peopleRepository.findByBookId(bookId);
    }
}
