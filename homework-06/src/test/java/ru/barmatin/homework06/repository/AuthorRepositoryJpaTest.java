package ru.barmatin.homework06.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.barmatin.homework06.domain.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий для работы с авторами")
@DataJpaTest
@Import(AuthorRepositoryJpa.class)
class AuthorRepositoryJpaTest {

    @Autowired
    private AuthorRepositoryJpa authorRepositoryJpa;

    @DisplayName("возвращает всех авторов в правильном порядке")
    @Test
    void getAll() {
        List<Author> authorList = authorRepositoryJpa.getAll();
        assertThat(authorList.size()).isEqualTo(5);
        assertThat(authorList.get(3).getSurname()).isEqualTo("Маркес");
    }

}