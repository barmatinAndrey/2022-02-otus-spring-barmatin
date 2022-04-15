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

    @DisplayName("проверяет, существует ли такой автор")
    @Test
    void exists() {
        boolean exists = authorDao.exists(new Author(0, "Готтлиб", "Лори", ""));
        assertThat(exists).isTrue();
    }

    @DisplayName("возвращает правильного автора по имени")
    @Test
    void getIdByName() {
        long count = authorDao.getIdByName(new Author(0, "Достоевский", "Федор", "Михайлович"));
        assertThat(count).isEqualTo(1);
    }

    @DisplayName("возвращает правильную секвенцию")
    @Test
    void getNextId() {
        assertThat(authorDao.getNextId()).isEqualTo(6);
    }

    @DisplayName("добавляет автора в БД")
    @Test
    void insert() {
        Author actualAuthor = new Author(6, "Толстой", "Лев", "Николаевич");
        authorDao.insert(actualAuthor);
        long expectedAuthorId = authorDao.getIdByName(new Author(0, "Толстой", "Лев", "Николаевич"));
        assertThat(actualAuthor.getId()).isEqualTo(expectedAuthorId);
    }
}