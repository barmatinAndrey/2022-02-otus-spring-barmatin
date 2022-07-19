package ru.barmatin.homework17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework17.domain.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> getAllByOrderBySurname();

}
