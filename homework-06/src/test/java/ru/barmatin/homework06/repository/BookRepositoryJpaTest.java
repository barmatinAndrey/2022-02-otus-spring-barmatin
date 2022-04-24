package ru.barmatin.homework06.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.barmatin.homework06.domain.Author;
import ru.barmatin.homework06.domain.Book;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий для работы с книгами")
@DataJpaTest
@Import(BookRepositoryJpa.class)
class BookRepositoryJpaTest {

    @Autowired
    private BookRepositoryJpa bookRepositoryJpa;

    @DisplayName("возвращает книгу по id")
    @Test
    void getBookById() {
        assertThat(bookRepositoryJpa.getBookById(2).getName()).isEqualTo("100 лет одиночества");
    }

    @DisplayName("возвращает все книги в правильном порядке")
    @Test
    void getAll() {
        List<Book> bookList = bookRepositoryJpa.getAll();
        assertThat(bookList.size()).isEqualTo(5);
        assertThat(bookList.get(0).getName()).isEqualTo("100 лет одиночества");
    }

    @DisplayName("удаляет книгу по id")
    @Test
    void deleteById() {
        bookRepositoryJpa.deleteById(1);
        assertThat(bookRepositoryJpa.getAll().size()).isEqualTo(4);
    }

    @DisplayName("добавляет книгу в БД")
    @Test
    void bookInsert() {
        Book book = new Book(0, "Идиот", new Author(1, "", "", ""), new ArrayList<>());
        int bookCountBeforeInsert = bookRepositoryJpa.getAll().size();
        bookRepositoryJpa.insert(book);
        int bookCountAfterInsert = bookRepositoryJpa.getAll().size();
        assertThat(bookCountAfterInsert).isEqualTo(bookCountBeforeInsert+1);
    }

    @DisplayName("изменяет книгу")
    @Test
    void bookUpdate() {
        Book book = new Book(5, "Адвокат Дьявола", new Author(1, "", "", ""), new ArrayList<>());
        bookRepositoryJpa.update(book);
        assertThat(bookRepositoryJpa.getBookById(5).getName()).isEqualTo(book.getName());
    }
}