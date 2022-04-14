package ru.barmatin.homework05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dao для работы с жанрами")
@JdbcTest
@Import(GenreDaoJdbc.class)
class GenreDaoJdbcTest {

    @Autowired
    private GenreDaoJdbc genreDao;

    @DisplayName("возвращает жанры в правильном порядке")
    @Test
    void getAll() {
        Genre genre = genreDao.getAll().get(6);
        assertThat(genre.getName()).isEqualTo("фантастика");
    }

    @DisplayName("возвращает правильное количество используемых жанров")
    @Test
    void getAllUsed() {
        assertThat(genreDao.getAllUsed().size()).isEqualTo(7);
    }

    @DisplayName("возвращает правильное жанр по части имени")
    @Test
    void getAllByName() {
        List<Genre> genreList = genreDao.getAllByName("фантас");
        assertThat(genreList.get(0).getName()).isEqualTo("фантастика");
    }

    @DisplayName("возвращает правильное количество жанров по части имени")
    @Test
    void getCountByName() {
        long count = genreDao.getCountByName("магическ");
        assertThat(count).isEqualTo(1);
    }

    @DisplayName("возвращает правильный id жанра по части имени")
    @Test
    void getIdByName() {
        long genreId = genreDao.getIdByName("триллер");
        assertThat(genreId).isEqualTo(3);
    }

    @DisplayName("возвращает правильное количество жанров")
    @Test
    void count() {
        assertThat(genreDao.getAll().size()).isEqualTo(7);
    }

    @DisplayName("добавлять жанр в БД")
    @Test
    void insert() {
        Genre actualGenre = new Genre(8, "комедия");
        genreDao.insert(actualGenre);
        long expectedGenreId = genreDao.getIdByName("комедия");
        assertThat(actualGenre.getId()).isEqualTo(expectedGenreId);
    }
}