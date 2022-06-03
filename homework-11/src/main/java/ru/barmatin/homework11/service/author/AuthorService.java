package ru.barmatin.homework11.service.author;

import ru.barmatin.homework11.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(String id);

}
