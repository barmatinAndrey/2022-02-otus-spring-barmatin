package ru.barmatin.homework06.repository;

import ru.barmatin.homework06.domain.Author;

import java.util.List;

public interface AuthorRepository {

    List<Author> getAll();

}
