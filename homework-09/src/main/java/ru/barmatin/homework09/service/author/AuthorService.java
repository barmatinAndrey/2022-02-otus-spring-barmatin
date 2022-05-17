package ru.barmatin.homework09.service.author;

import ru.barmatin.homework09.domain.Author;
import ru.barmatin.homework09.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    List<AuthorDto> getAllAuthorsDto();

}
