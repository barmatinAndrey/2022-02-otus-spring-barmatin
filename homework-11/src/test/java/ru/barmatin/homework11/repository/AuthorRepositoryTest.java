package ru.barmatin.homework11.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.barmatin.homework11.domain.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void getAllByOrderBySurname() {
        List<Author> authorList = authorRepository.getAllByOrderBySurname();
        assertThat(authorList.size()).isEqualTo(5);
        assertThat(authorList.get(0).getSurname()).isEqualTo("Готтлиб");
        assertThat(authorList.get(1).getSurname()).isEqualTo("Достоевский");
        assertThat(authorList.get(2).getSurname()).isEqualTo("Дюморье");
        assertThat(authorList.get(3).getSurname()).isEqualTo("Маркес");
        assertThat(authorList.get(4).getSurname()).isEqualTo("Тартт");
    }

}