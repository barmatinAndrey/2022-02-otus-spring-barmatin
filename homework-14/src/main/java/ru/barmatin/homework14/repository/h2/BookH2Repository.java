package ru.barmatin.homework14.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework14.domain.h2.BookH2;

public interface BookH2Repository extends JpaRepository<BookH2, Long> {

}
