package ru.babinnikolay.library.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.babinnikolay.library.model.Person;
import ru.babinnikolay.library.model.PersonRowMapper;

import java.util.List;

/**
 * @author Babin Nikolay
 */
@Repository
@AllArgsConstructor
public class JDBCPeopleRepository implements PeopleRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT person_id, name FROM people",
                new PersonRowMapper());
    }

    @Override
    public Person findById(Long id) {
        return jdbcTemplate.query("SELECT person_id, name FROM people WHERE person_id=?", new Object[]{id},
                new PersonRowMapper()).stream().findAny().orElse(null);
    }

    @Override
    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO people (name) values (?)", person.getName());
    }

    @Override
    public void update(Long id, Person person) {
        jdbcTemplate.update("UPDATE people SET name=? WHERE person_id=?", person.getName(), id);
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM people WHERE person_id=?", id);
    }
}
