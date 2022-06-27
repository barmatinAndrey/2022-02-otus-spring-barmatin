package ru.barmatin.homework13.exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework13.domain.LibraryUser;


public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {

    LibraryUser findByUsername(String username);

}
