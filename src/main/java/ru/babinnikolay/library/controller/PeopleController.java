package ru.babinnikolay.library.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.babinnikolay.library.model.Person;
import ru.babinnikolay.library.service.PeopleService;

/**
 * @author Babin Nikolay
 */
@Controller
@RequestMapping("/people")
@AllArgsConstructor
@Log4j2
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping
    public String people(Model model) {
        log.info("Get people list");
        model.addAttribute("people", peopleService.findAll());
        return "people/people";
    }

    @GetMapping("/{id}")
    public String getPerson(Model model, @PathVariable Long id) {
        log.info("Get person by id={}", id);
        model.addAttribute("person", peopleService.findById(id));
        return "people/person";
    }

    @GetMapping("/new")
    public String getNewForm(Model model) {
        log.info("Get form new Person");
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person) {
        log.info("Post new person={}", person);
        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id) {
        log.info("Get edit form for id={}", id);
        Person person = peopleService.findById(id);
        model.addAttribute("person", person);
        return "people/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute("person") Person person, @PathVariable Long id) {
        log.info("Edit person={}", person);
        peopleService.update(id, person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable Long id) {
        log.info("Get delete form for id={}", id);
        Person person = peopleService.findById(id);
        model.addAttribute("person", person);
        return "people/delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        log.info("Delete person id={}", id);
        peopleService.deleteById(id);
        return "redirect:/people";
    }
}
