DROP DATABASE IF EXISTS library;

CREATE DATABASE library;

USE library;

DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book;

CREATE TABLE author
(
    id        int not null AUTO_INCREMENT,
    name      varchar(45),
    last_name varchar(45),
    PRIMARY KEY (id)
);

CREATE TABLE book
(
    id        int not null AUTO_INCREMENT,
    name      varchar(45),
    author_id int not NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES author (id)
);

INSERT INTO author(id, name, last_name)
VALUES (DEFAULT, 'John1', 'Baker'),
       (DEFAULT, 'John2', 'Baker'),
       (DEFAULT, 'John3', 'Baker'),
       (DEFAULT, 'John4', 'Baker'),
       (DEFAULT, 'John5', 'Baker'),
       (DEFAULT, 'John6', 'Baker'),
       (DEFAULT, 'John7', 'Baker'),
       (DEFAULT, 'John8', 'Baker'),
       (DEFAULT, 'John9', 'Baker'),
       (DEFAULT, 'John10', 'Baker');


INSERT INTO book(id, name, author_id)
VALUES (DEFAULT, 'Book1', 1),
       (DEFAULT, 'Book1', 2),
       (DEFAULT, 'Book1', 3),
       (DEFAULT, 'Book1', 4),
       (DEFAULT, 'Book1', 5),
       (DEFAULT, 'Book1', 6),
       (DEFAULT, 'Book1', 7),
       (DEFAULT, 'Book1', 8),
       (DEFAULT, 'Book1', 9),
       (DEFAULT, 'Book1', 10);