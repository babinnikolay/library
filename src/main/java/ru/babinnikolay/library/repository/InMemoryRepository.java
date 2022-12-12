package ru.babinnikolay.library.repository;

import org.springframework.stereotype.Component;
import ru.babinnikolay.library.model.Person;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Babin Nikolay
 */
@Component
public class InMemoryRepository implements Repository{
    private long maxKey = 2l;
    private final Map<Long, Person> people;
    {
        people = new HashMap<>();
        people.put(1l, new Person(1, "One"));
        people.put(2l, new Person(2, "Two"));
    }
    @Override
    public List<Person> findAll() {
        return people.values().stream().toList();
    }

    @Override
    public Person findById(Long id) {
        return people.getOrDefault(id, null);
    }

    @Override
    public void save(Person person) {
        person.setId(++maxKey);
        people.put(maxKey, person);
    }
}
