package ru.babinnikolay.library.controller;

import lombok.AllArgsConstructor;
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
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping
    public String people(Model model) {
        model.addAttribute("people", peopleService.findAll());
        return "people/people";
    }

    @GetMapping("/{id}")
    public String getPerson(Model model, @PathVariable Long id) {
        model.addAttribute("person", peopleService.findById(id));
        return "people/person";
    }

    @GetMapping("/new")
    public String getNewForm(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person) {
        peopleService.save(person);
        return "redirect:/people";
    }
}
