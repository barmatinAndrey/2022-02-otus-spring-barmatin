package ru.barmatin.homework13.exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework13.domain.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> getAllByOrderBySurname();

}
