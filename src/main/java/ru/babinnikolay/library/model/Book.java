package ru.babinnikolay.library.model;

import lombok.*;

/**
 * @author Babin Nikolay
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private long id;
    private String name;
}
