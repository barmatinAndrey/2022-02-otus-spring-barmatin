package ru.barmatin.homework06.repository;

import org.springframework.stereotype.Repository;
import ru.barmatin.homework06.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentRepositoryJpa implements CommentRepository {
    private final EntityManager em;

    public CommentRepositoryJpa(EntityManager em) {
        this.em = em;
    }


    @Override
    public Comment getCommentById(long id) {
        return em.find(Comment.class, id);
    }

    @Override
    public List<Comment> getAllByBookId(long bookId) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.book.id = :bookId", Comment.class);
        query.setParameter("bookId", bookId);
        return query.getResultList();
    }

    @Override
    public void deleteById(long id) {
        em.remove(getCommentById(id));
    }

    @Override
    public void insert(Comment comment) {
        em.persist(comment);
    }

    @Override
    public void update(Comment comment) {
        em.merge(comment);
    }
}
