package ru.barmatin.homework09.service.book;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.barmatin.homework09.service.comment.CommentService;
import ru.barmatin.homework09.service.comment.CommentServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({BookServiceImpl.class, CommentServiceImpl.class})
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TestEntityManager em;

    @Test
    void getAllAvailableBooksRequestCount() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);
        bookService.getAllAvailableBooksDto();
        long count = sessionFactory.getStatistics().getPrepareStatementCount();
        assertThat(count).isEqualTo(2);
        // С @Fetch(FetchMode.SUBSELECT) над List<Genre> genreList в Book получается 2 запроса, без него 6, так и думал)
    }
}