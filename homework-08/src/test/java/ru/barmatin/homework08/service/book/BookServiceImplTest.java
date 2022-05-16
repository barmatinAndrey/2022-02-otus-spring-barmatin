package ru.barmatin.homework08.service.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import ru.barmatin.homework08.dto.BookDTO;
import ru.barmatin.homework08.service.author.AuthorServiceImpl;
import ru.barmatin.homework08.service.comment.CommentServiceImpl;
import ru.barmatin.homework08.service.genre.GenreServiceImpl;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@Import({BookServiceImpl.class, AuthorServiceImpl.class,  GenreServiceImpl.class,
        CommentServiceImpl.class, BookMappingServiceImpl.class})
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    void findAllByOrderByName() {
        List<BookDTO> bookDTOList = bookService.getAllAvailableBooks();
        assertThat(bookDTOList).hasSize(5).extracting(BookDTO::getName)
                .containsExactlyInAnyOrder("100 лет одиночества", "Вы хотите поговорить об этом?",
                        "Преступление и наказание", "Ребекка", "Щегол");
    }

}