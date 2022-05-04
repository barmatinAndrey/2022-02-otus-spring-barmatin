package ru.barmatin.homework07.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.barmatin.homework07.domain.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    void findAllByOrderByName() {
        List<Genre> genreList = genreRepository.findAllByOrderByName();
        assertThat(genreList.size()).isEqualTo(7);
        assertThat(genreList.get(0).getName()).isEqualTo("детектив");
        assertThat(genreList.get(1).getName()).isEqualTo("магический реализм");
        assertThat(genreList.get(2).getName()).isEqualTo("психология");
        assertThat(genreList.get(3).getName()).isEqualTo("роман");
        assertThat(genreList.get(4).getName()).isEqualTo("трагедия");
        assertThat(genreList.get(5).getName()).isEqualTo("триллер");
        assertThat(genreList.get(6).getName()).isEqualTo("фантастика");
    }
}