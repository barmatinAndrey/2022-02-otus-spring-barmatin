package ru.barmatin.homework14.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework14.domain.h2.GenreH2;

import java.util.List;

public interface GenreH2Repository extends JpaRepository<GenreH2, Long> {

}
