package ru.barmatin.homework12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework12.domain.LibraryUser;


public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {

    LibraryUser findByUsername(String username);

}
