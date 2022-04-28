package ru.barmatin.homework06.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.barmatin.homework06.domain.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий для работы с жанрами")
@DataJpaTest
@Import(GenreRepositoryJpa.class)
class GenreRepositoryJpaTest {

    @Autowired
    private GenreRepositoryJpa genreRepositoryJpa;

    @DisplayName("возвращает жанры в правильном порядке")
    @Test
    void getAll() {
        List<Genre> genreList = genreRepositoryJpa.getAll();
        assertThat(genreList.size()).isEqualTo(7);
        assertThat(genreList.get(6).getName()).isEqualTo("фантастика");
    }

}