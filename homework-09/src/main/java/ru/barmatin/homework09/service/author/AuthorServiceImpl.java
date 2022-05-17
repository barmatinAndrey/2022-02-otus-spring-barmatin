package ru.barmatin.homework09.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework09.dto.AuthorDto;
import ru.barmatin.homework09.repository.AuthorRepository;

import ru.barmatin.homework09.domain.Author;

import java.util.ArrayList;
import java.util.List;

import static ru.barmatin.homework09.util.MappingUtils.mapAuthorToDto;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAllByOrderBySurname();
    }

    @Override
    public List<AuthorDto> getAllAuthorsDto() {
        List<Author> authorList = authorRepository.getAllByOrderBySurname();
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for (Author author: authorList) {
            authorDtoList.add(mapAuthorToDto(author));
        }
        return authorDtoList;
    }
}
