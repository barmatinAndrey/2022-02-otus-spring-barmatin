package ru.barmatin.homework08.service.author;

import ru.barmatin.homework08.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(String id);

}
