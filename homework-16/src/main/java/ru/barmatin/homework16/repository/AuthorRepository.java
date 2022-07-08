package ru.barmatin.homework16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework16.domain.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> getAllByOrderBySurname();

}
