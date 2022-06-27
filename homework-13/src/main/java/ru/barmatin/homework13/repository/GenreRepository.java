package ru.barmatin.homework13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework13.domain.Genre;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findAllByOrderByName();

}
