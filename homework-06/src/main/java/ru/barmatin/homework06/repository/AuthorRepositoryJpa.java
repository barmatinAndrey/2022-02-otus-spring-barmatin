package ru.barmatin.homework06.repository;


import org.springframework.stereotype.Repository;
import ru.barmatin.homework06.domain.Author;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class AuthorRepositoryJpa implements AuthorRepository {
    private final EntityManager em;

    public AuthorRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = em.createQuery("select a from Author a order by a.surname", Author.class);
        return query.getResultList();
    }

}
