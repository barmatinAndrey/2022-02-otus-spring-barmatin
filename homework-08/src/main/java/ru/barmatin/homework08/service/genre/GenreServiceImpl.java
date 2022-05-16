package ru.barmatin.homework08.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.barmatin.homework08.repository.GenreRepository;
import ru.barmatin.homework08.domain.Genre;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll(Sort.by("name"));
    }

    @Override
    public Optional<Genre> getGenreById(String id) {
        return genreRepository.findById(id);
    }
}
