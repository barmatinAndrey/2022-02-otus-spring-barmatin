package ru.barmatin.homework17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework17.domain.Genre;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findAllByOrderByName();

}
