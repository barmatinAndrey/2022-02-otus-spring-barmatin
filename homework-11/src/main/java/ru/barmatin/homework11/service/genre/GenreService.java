package ru.barmatin.homework11.service.genre;

import ru.barmatin.homework11.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    List<Genre> getAllGenres();

    Optional<Genre> getGenreById(String id);

}
