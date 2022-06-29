package ru.barmatin.homework14.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework14.domain.h2.AuthorH2;

import java.util.List;

public interface AuthorH2Repository extends JpaRepository<AuthorH2, Long> {

}
