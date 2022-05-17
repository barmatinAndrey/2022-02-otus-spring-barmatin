package ru.barmatin.homework09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework09.domain.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> getAllByOrderBySurname();

}
