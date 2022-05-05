package ru.barmatin.homework08.service.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import ru.barmatin.homework08.domain.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@Import(GenreServiceImpl.class)
class GenreServiceImplTest {

    @Autowired
    private GenreService genreService;

    @Test
    void getAllGenres() {
        List<Genre> genreList = genreService.getAllGenres();
        assertThat(genreList).hasSize(7).extracting(Genre::getName)
                .containsExactlyInAnyOrder("детектив", "магический реализм",
                        "психология", "роман", "трагедия", "триллер", "фантастика");
    }

}