package ru.barmatin.homework13.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostFilter;
import ru.barmatin.homework13.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @EntityGraph(attributePaths = "author")
    @Override
    Optional<Book> findById(Long id);

    @EntityGraph(attributePaths = "author")
    List<Book> findAllByOrderByName();

}
