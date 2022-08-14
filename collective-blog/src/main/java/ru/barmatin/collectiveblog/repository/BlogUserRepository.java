package ru.barmatin.collectiveblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.collectiveblog.domain.BlogUser;

public interface BlogUserRepository extends JpaRepository<BlogUser, Integer> {

    BlogUser findByUsername(String username);

}
