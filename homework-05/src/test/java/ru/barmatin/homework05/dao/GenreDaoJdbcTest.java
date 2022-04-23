package ru.barmatin.homework05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
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

    @DisplayName("возвращает правильное количество жанров для книги")
    @Test
    void getAllByBookId() {
        List<Genre> genreList = genreDao.getAllByBookId(3);
        assertThat(genreList.size()).isEqualTo(4);
    }

}