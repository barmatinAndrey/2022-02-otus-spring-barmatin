package ru.barmatin.homework06.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework06.repository.GenreRepository;
import ru.barmatin.homework06.domain.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.getAll();
    }
}
