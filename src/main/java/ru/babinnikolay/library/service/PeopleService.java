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
    private final PeopleRepository repository;
    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        return repository.findById(id);
    }

    public void save(Person person) {
        repository.save(person);
    }

    public void update(Long id, Person person) {
        repository.update(id, person);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
