package ru.barmatin.homework14.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework14.domain.h2.AuthorH2;
import ru.barmatin.homework14.domain.h2.GenreH2;

import java.util.List;
import java.util.Optional;

public interface GenreH2Repository extends JpaRepository<GenreH2, Long> {

    Optional<GenreH2> findByName(String name);

}
