package ru.barmatin.homework12.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework12.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @EntityGraph(attributePaths = "author")
    @Override
    Optional<Book> findById(Long id);

    @EntityGraph(attributePaths = "author")
    List<Book> findAllByOrderByName();

}
