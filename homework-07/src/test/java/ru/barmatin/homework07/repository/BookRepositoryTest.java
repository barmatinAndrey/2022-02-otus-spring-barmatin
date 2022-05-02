package ru.barmatin.homework07.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.barmatin.homework07.domain.Author;
import ru.barmatin.homework07.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    void findById() {
        Optional<Book> book = bookRepository.findById(2L);
        assertThat(book.get()).isNotNull();
        assertThat(book.get().getName()).isEqualTo("100 лет одиночества");
    }

    @Test
    void findAllByOrderByName() {
        List<Book> bookList = bookRepository.findAllByOrderByName();
        assertThat(bookList.size()).isEqualTo(5);
        assertThat(bookList.get(0).getName()).isEqualTo("100 лет одиночества");
        assertThat(bookList.get(1).getName()).isEqualTo("Вы хотите поговорить об этом?");
        assertThat(bookList.get(2).getName()).isEqualTo("Преступление и наказание");
        assertThat(bookList.get(3).getName()).isEqualTo("Ребекка");
        assertThat(bookList.get(4).getName()).isEqualTo("Щегол");
    }

    @Test
    void addNewBook() {
        long bookId = (long)em.persistAndGetId(new Book(0, "Идиот",
                new Author(1, "", "", ""), new ArrayList<>()));
        Book book = em.find(Book.class, bookId);
        assertThat(book.getName()).isEqualTo("Идиот");
        assertThat(book.getAuthor().getId()).isEqualTo(1);
    }

}