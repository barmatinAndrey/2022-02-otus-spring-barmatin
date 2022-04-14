package ru.barmatin.homework05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.barmatin.homework05.domain.Author;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dao для работы с авторами должно")
@JdbcTest
@Import(AuthorDaoJdbc.class)
class AuthorDaoJdbcTest {

    @Autowired
    private AuthorDaoJdbc authorDao;

    @DisplayName("возвращает авторов в правильном порядке")
    @Test
    void getAll() {
        Author actualAuthor = authorDao.getAll().get(3);
        assertThat(actualAuthor.getSurname()).isEqualTo("Маркес");
    }

    @DisplayName("возвращать правильное количество авторов по имени")
    @Test
    void getCountByName() {
        long count = authorDao.getCountByName("Достоевский", "Федор", "Михайлович");
        assertThat(count).isEqualTo(1);
    }

    @DisplayName("возвращать правильный id автора по имени")
    @Test
    void getIdByName() {
        long authorId = authorDao.getIdByName("Готтлиб", "Лори", "");
        assertThat(authorId).isEqualTo(4);
    }

    @DisplayName("возвращать правильное количество авторов")
    @Test
    void count() {
        assertThat(authorDao.getAll().size()).isEqualTo(5);
    }

    @DisplayName("добавлять автора в БД")
    @Test
    void insert() {
        Author actualAuthor = new Author(6, "Толстой", "Лев", "Николаевич");
        authorDao.insert(actualAuthor);
        long expectedAuthorId = authorDao.getIdByName("Толстой", "Лев", "Николаевич");
        assertThat(actualAuthor.getId()).isEqualTo(expectedAuthorId);
    }
}