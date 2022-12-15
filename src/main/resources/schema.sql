DROP TABLE IF EXISTS people_book;
DROP TABLE IF EXISTS people;
DROP TABLE IF EXISTS books;

CREATE TABLE people(
    person_id SERIAL PRIMARY KEY,
    name VARCHAR(250)
);

CREATE TABLE books(
    book_id SERIAL PRIMARY KEY,
    name VARCHAR(250)
);

CREATE TABLE people_book(
    person_id INTEGER REFERENCES people(person_id),
    book_id INTEGER REFERENCES books(book_id),
    UNIQUE (person_id, book_id)
)
