package ru.barmatin.homework06.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.barmatin.homework06.domain.Book;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;


@Repository
public class BookRepositoryJpa implements BookRepository {
    private final EntityManager em;

    @Autowired
    public BookRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Book getBookById(long id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("select b from Book b join fetch b.author order by b.name", Book.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(long id) {
        em.remove(getBookById(id));
    }

    @Override
    public void insert(Book book) {
        em.persist(book);
    }

    @Override
    public void update(Book book) {
        em.merge(book);
    }

}
