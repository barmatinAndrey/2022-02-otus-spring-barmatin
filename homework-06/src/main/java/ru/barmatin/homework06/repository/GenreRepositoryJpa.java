package ru.barmatin.homework06.repository;

import org.springframework.stereotype.Repository;
import ru.barmatin.homework06.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GenreRepositoryJpa implements GenreRepository {
    private final EntityManager em;

    public GenreRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Genre> getAll() {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g order by g.name", Genre.class);
        return query.getResultList();
    }

}
