package ru.barmatin.homework11.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.barmatin.homework11.domain.Author;
import ru.barmatin.homework11.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll(Sort.by("surname"));
    }

    @Override
    public Optional<Author> getAuthorById(String id) {
        return authorRepository.findById(id);
    }
}
